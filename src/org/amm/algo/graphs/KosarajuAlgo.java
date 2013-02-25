package org.amm.algo.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.amm.algo.graphs.sd.AdjacencyList;
import org.amm.algo.graphs.sd.Vertix;

/**
 * 
 *
 */
public class KosarajuAlgo {

	private ArrayList<Vertix> order;
	private ArrayList<Boolean> visitedVertices = new ArrayList<Boolean>();

	private void processVisitedVertices(int size){
		for (int i = 0; i < size; i++) {
			visitedVertices.add(false);
		}
	}
	
	public List<Integer> find(AdjacencyList adjacencyList) {

		// TODO
		// 2

		Map<Integer, ArrayList<Vertix>> result = getSCC(adjacencyList);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		printSCC(result);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		return findSizeOfEachComponent(result);
	}

	public void printSCC(Map<Integer, ArrayList<Vertix>> result){
		for (Entry<Integer, ArrayList<Vertix>> entry : result.entrySet()) {
			Integer i = entry.getKey();
			System.out.print(i + ":\t");
			for (Vertix v : entry.getValue()) {
				System.out.print(v.getName() + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param result
	 * @return
	 */
	public List<Integer> findSizeOfEachComponent(Map<Integer, ArrayList<Vertix>> result) {

		List<Integer> temp = new ArrayList<Integer>();
		for (Integer i : result.keySet()) {
			temp.add(result.get(i).size());
		}
		Collections.sort(temp);
		return temp;
	}

	public Map<Integer, ArrayList<Vertix>> getSCC(AdjacencyList list) {

		order = new ArrayList<Vertix>();
		processVisitedVertices(list.getAdjacencies().size());
		
		// search the graph (depth-first search), adding Vertixs to the stack
		dfsLoop(list);

		// reverse all the edges in the graph
		list.reverseGraph();
		//list.printList();

		processVisitedVertices(list.getAdjacencies().size());
		
		return dfsLoop2(list);
	}

	private void dfsLoop(AdjacencyList list) {
		for (Vertix vertix : list.getAdjacencies().keySet()) {
			if (!visitedVertices.get(vertix.getName() - 1)) {
				dfs(vertix, list, true);
			}
		}
	}

	private Map<Integer, ArrayList<Vertix>> dfsLoop2(AdjacencyList list) {

		Map<Integer, ArrayList<Vertix>> scc = new HashMap<Integer, ArrayList<Vertix>>();

		for (int i = 0; i < order.size(); i++) {
			if (!visitedVertices.get(order.get(i).getName() - 1)) {
				ArrayList<Vertix> component = new ArrayList<Vertix>();
				dfs2(order.get(i), list, component);
				scc.put(i, component);
			}
		}
		return scc;
	}

	private void dfs(Vertix root, AdjacencyList list, boolean forward) {

		visitedVertices.set(root.getName() - 1, forward);

		if (list.getAdjacent(root) == null) {
			if (forward)
				order.add(0, root);
			return;
		}

		for (Vertix vertix : list.getAdjacent(root)) {
			if (visitedVertices.get(vertix.getName() - 1) != forward) {
				dfs(vertix, list, forward);
			}
		}
		if (forward)
			order.add(0, root);
	}

	private void dfs2(Vertix root, AdjacencyList list,
			ArrayList<Vertix> component) {

		visitedVertices.set(root.getName() - 1, true);

		if (list.getAdjacent(root) == null) {
			component.add(root);
			// if (forward)
			// order.add(0, root);
			return;
		}

		for (Vertix vertix : list.getAdjacent(root)) {
			if (visitedVertices.get(vertix.getName() - 1) != true) {
				dfs2(vertix, list, component);
			}
		}
		component.add(root);

	}

}
