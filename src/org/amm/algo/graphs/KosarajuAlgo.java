package org.amm.algo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.amm.algo.graphs.sd.AdjacencyList;
import org.amm.algo.graphs.sd.Vertix;

/**
 * 
 *
 */
public class KosarajuAlgo<T> {

	private ArrayList<Vertix<T>> order;

	public List<Integer> find(AdjacencyList<T> adjacencyList, int maxResults){
		//TODO
		Vertix<T> root = adjacencyList.getRandomVertix();
		
		Map<Integer, ArrayList<Vertix<T>>> result = getSCC(root, adjacencyList);
		Object array = result.keySet().toArray();
		
		List<Integer> r = new ArrayList<Integer>(Arrays.asList((Integer[] )array));
		Collections.sort(r);
		
		return r;
	}

	public Map<Integer, ArrayList<Vertix<T>>> getSCC(Vertix<T> root,
			AdjacencyList<T> list) {

		order = new ArrayList<Vertix<T>>();

		// search the graph (depth-first search), adding Vertix<T>s to the stack
		search(root, list, true);

		// reverse all the edges in the graph
		list.reverseGraph();

		// search the graph again in the stack's order
		Map<Integer, ArrayList<Vertix<T>>> scc = new HashMap<Integer, ArrayList<Vertix<T>>>();
		while (!order.isEmpty()) {
			ArrayList<Vertix<T>> component = new ArrayList<Vertix<T>>();
			search(order.get(0), list, false);

			// any components we visited are strongly connected
			// remove them from the stack and add them to the component
			for (Iterator<Vertix<T>> it = order.iterator(); it.hasNext();) {
				Vertix<T> n = it.next();
				if (!n.isVisited()) {
					component.add(n);
					it.remove();
				}
			}

			// add the component to the result set
			scc.put(component.size(), component);
		}
		return scc;
	}

	private void search(Vertix<T> root, AdjacencyList<T> list, boolean forward) {

		root.setVisited(forward);

		if (list.getAdjacent(root) == null) {
			if (forward)
				order.add(0, root);
			return;
		}

		for (Vertix<T> vertix : list.getAdjacent(root)) {
			if (vertix.isVisited() != forward) {
				search(vertix, list, forward);
			}
		}
		if (forward)
			order.add(0, root);
	}
}
