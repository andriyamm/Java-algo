package org.amm.algo.graphs.scc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


/**
 * Kosaraju's algorithm is an algorithm to find the strongly connected
 * components of a directed graph.
 * 
 */
//TODO: needs optimization
//TODO: needs logging
public class KosarajuAlgo {

	private ArrayList<Integer> order;
	private boolean[] visitedVertices;
	private AdjacencyList adjacencyList = new AdjacencyList();
	private int verticesCount;

	
	public void init(String filename) throws FileNotFoundException {
		adjacencyList.setAdjacencies(readData(filename));
	}

	private void processVisitedVertices() {
		visitedVertices = new boolean[verticesCount];
		Arrays.fill(visitedVertices, false);
	}

	/**
	 * method prints on screen Strongly Conected Component (SCC)
	 * 
	 * @param SCCs
	 *            map which contain Strongly Conected Components (SCCs)
	 */
	public void printSCCs(Map<Integer, ArrayList<Integer>> SCCs) {
		for (Entry<Integer, ArrayList<Integer>> entry : SCCs.entrySet()) {
			Integer i = entry.getKey();
			System.out.print(i + ":\t");
			for (Integer v : entry.getValue()) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Method create the list which contain the size of each Strongly Conected
	 * Component (SCC)
	 * 
	 * @param SCCs
	 *            map which contain Strongly Conected Components (SCCs)
	 * @return the List<Integer> which contain the size of each Strongly
	 *         Conected Component (SCC)
	 */
	public List<Integer> findSizeOfEachComponent(
			Map<Integer, ArrayList<Integer>> SCCs) {

		List<Integer> temp = new ArrayList<Integer>();
		for (Integer i : SCCs.keySet()) {
			temp.add(SCCs.get(i).size());
		}
		return temp;
	}

	/**
	 * Find all Strongly Conected Components (SCCs)
	 * 
	 * @return map which contain Strongly Conected Components (SCCs)
	 */
	public Map<Integer, ArrayList<Integer>> findSCCs() {

		order = new ArrayList<Integer>();
		processVisitedVertices();

		// search the graph (depth-first search), adding Integers to the stack
		dfsLoop(adjacencyList);

		// reverse all the edges in the graph
		adjacencyList.reverseGraph();

		Arrays.fill(visitedVertices, false);

		return reverseDfsLoop(adjacencyList);
	}

	/**
	 * Depth-first search on graph
	 * 
	 * @param list
	 */
	private void dfsLoop(AdjacencyList list) {
		for (Integer vertix : list.getAdjacencies().keySet()) {
			if (!visitedVertices[vertix - 1]) {
				dfs(vertix, list, true);
			}
		}
	}

	/**
	 * Depth-first search on reverse graph
	 * 
	 * @param list
	 * @return
	 * 		Strongly Conected Components (SCCs)
	 */
	private Map<Integer, ArrayList<Integer>> reverseDfsLoop(AdjacencyList list) {

		Map<Integer, ArrayList<Integer>> scc = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < order.size(); i++) {
			if (!visitedVertices[order.get(i) - 1]) {
				ArrayList<Integer> component = new ArrayList<Integer>();
				reverseDfs(order.get(i), list, component);
				scc.put(i, component);
			}
		}
		return scc;
	}

	private void dfs(Integer root, AdjacencyList list, boolean forward) {

		visitedVertices[root - 1] = forward;

		if (list.getAdjacent(root) == null) {
			if (forward)
				order.add(0, root);
			return;
		}

		for (Integer vertix : list.getAdjacent(root)) {
			if (visitedVertices[vertix - 1] != forward) {
				dfs(vertix, list, forward);
			}
		}
		if (forward)
			order.add(0, root);
	}

	private void reverseDfs(Integer root, AdjacencyList list,
			ArrayList<Integer> component) {

		visitedVertices[root - 1] = true;

		if (list.getAdjacent(root) == null) {
			component.add(root);
			return;
		}

		for (Integer vertix : list.getAdjacent(root)) {
			if (visitedVertices[vertix - 1] != true) {
				reverseDfs(vertix, list, component);
			}
		}
		component.add(root);
	}

	/**
	 * Read data from file
	 * 
	 * The file contains the edges of a directed graph. Vertices are labeled as
	 * positive integers from 1. Every row indicates an edge, the vertex label
	 * in first column is the tail and the vertex label in second column is the
	 * head (recall the graph is directed, and the edges are directed from the
	 * first column vertex to the second column vertex). So for example, the
	 * some row looks liks : "2 4". This just means that the vertex with label 2
	 * has an outgoing edge to the vertex with label 4.
	 * 
	 * 
	 * @param filename
	 *            path to file with data
	 * @return
	 * @throws FileNotFoundException
	 */
	public Map<Integer, Set<Integer>> readData(String filename)
			throws FileNotFoundException {

		Map<Integer, Set<Integer>> data = new HashMap<Integer, Set<Integer>>();
		Integer from = null, to = null;
		Set<Integer> adjacencies = null;

		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			if (rowReader.hasNextInt()) {

				// first number in row is the vertex label,
				// we will used it as key in map
				from = rowReader.nextInt();
				// second number in row
				if (rowReader.hasNextInt()) {
					to = rowReader.nextInt();
				}

				if (!data.containsKey(from)) {
					adjacencies = new HashSet<Integer>();
					data.put(from, adjacencies);
				} else {
					adjacencies = data.get(from);
				}
				adjacencies.add(to);
			}
			data.put(from, adjacencies);
		}
		verticesCount = from;
		return data;
	}

}
