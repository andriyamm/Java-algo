package org.amm.algo.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.amm.algo.graphs.sd.AdjacencyList;


/**
 * 
 *
 */
public class KosarajuAlgo {

	private ArrayList<Integer> order;
	//private ArrayList<Boolean> visitedVertices = new ArrayList<Boolean>();
	private boolean[] visitedVertices;
	
	private AdjacencyList adjacencyList = new AdjacencyList();
	private int verticesCount;
	
	public void init(String filename) throws FileNotFoundException{
		adjacencyList.setAdjacencies(readData(filename));
	}
	
	private void processVisitedVertices(){
		//for (int i = 0; i < verticesCount; i++) {
			//visitedVertices.add(false);
		//}
		visitedVertices = new boolean[verticesCount];
		Arrays.fill(visitedVertices, false);
	}
	
	public List<Integer> find() {

		// TODO
		// 2

		Map<Integer, ArrayList<Integer>> result = findSCCs();
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
//		printSCC(result);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		return findSizeOfEachComponent(result);
	}

	public void printSCCs(Map<Integer, ArrayList<Integer>> result){
		for (Entry<Integer, ArrayList<Integer>> entry : result.entrySet()) {
			Integer i = entry.getKey();
			System.out.print(i + ":\t");
			for (Integer v : entry.getValue()) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param result
	 * @return
	 */
	public List<Integer> findSizeOfEachComponent(Map<Integer, ArrayList<Integer>> result) {

		List<Integer> temp = new ArrayList<Integer>();
		for (Integer i : result.keySet()) {
			temp.add(result.get(i).size());
		}
		Collections.sort(temp);
		return temp;
	}

	public Map<Integer, ArrayList<Integer>> findSCCs() {

		order = new ArrayList<Integer>();
		processVisitedVertices();
		
		// search the graph (depth-first search), adding Integers to the stack
		dfsLoop(adjacencyList);

		// reverse all the edges in the graph
		adjacencyList.reverseGraph();
		//list.printList();

		//Collections.fill(visitedVertices, false);
		Arrays.fill(visitedVertices, false);
		
		return dfsLoop2(adjacencyList);
	}

	private void dfsLoop(AdjacencyList list) {
		for (Integer vertix : list.getAdjacencies().keySet()) {
			//if (!visitedVertices.get(vertix - 1)) {
			if (!visitedVertices[vertix - 1]) {
				dfs(vertix, list, true);
			}
		}
	}

	private Map<Integer, ArrayList<Integer>> dfsLoop2(AdjacencyList list) {

		Map<Integer, ArrayList<Integer>> scc = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < order.size(); i++) {
			//if (!visitedVertices.get(order.get(i) - 1)) {
			if (!visitedVertices[order.get(i) - 1]) {
				ArrayList<Integer> component = new ArrayList<Integer>();
				dfs2(order.get(i), list, component);
				scc.put(i, component);
			}
		}
		return scc;
	}

	private void dfs(Integer root, AdjacencyList list, boolean forward) {

		//visitedVertices.set(root - 1, forward);
		visitedVertices[root - 1] = forward;
		
		if (list.getAdjacent(root) == null) {
			if (forward)
				order.add(0, root);
			return;
		}

		for (Integer vertix : list.getAdjacent(root)) {
			//if (visitedVertices.get(vertix - 1) != forward) {
			if (visitedVertices[vertix - 1] != forward) {	
				dfs(vertix, list, forward);
			}
		}
		if (forward)
			order.add(0, root);
	}

	private void dfs2(Integer root, AdjacencyList list,
			ArrayList<Integer> component) {

		//visitedVertices.set(root - 1, true);
		visitedVertices[root - 1] = true;
		
		if (list.getAdjacent(root) == null) {
			component.add(root);
			// if (forward)
			// order.add(0, root);
			return;
		}

		for (Integer vertix : list.getAdjacent(root)) {
			//if (visitedVertices.get(vertix - 1) != true) {
			if (visitedVertices[vertix - 1] != true) {	
				dfs2(vertix, list, component);
			}
		}
		component.add(root);

	}
	
	/**
	 * TODO
	 * 
	 * @param <T>
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("resource")
	private Map<Integer, Set<Integer>> readData(
			String filename) throws FileNotFoundException {

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
