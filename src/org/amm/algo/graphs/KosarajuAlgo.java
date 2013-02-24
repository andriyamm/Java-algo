package org.amm.algo.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.amm.algo.graphs.sd.AdjacencyList;
import org.amm.algo.graphs.sd.IEdge;
import org.amm.algo.graphs.sd.Vertix;

/**
 * 
 *
 */
public class KosarajuAlgo<T> {

	private ArrayList<Vertix<T>> stack;

	public void run(Map<Vertix<Integer>, Set<Vertix<Integer>>> graph){
		
	}
	
	public ArrayList<ArrayList<Vertix<T>>> getSCC(Vertix<T> root,
			AdjacencyList<T> list) {
		
		stack = new ArrayList<Vertix<T>>();

		// search the graph (depth-first search), adding Vertix<T>s to the stack
		search(root, list, true);

		// reverse all the edges in the graph
		list.reverseGraph();

		// search the graph again in the stack's order
		ArrayList<ArrayList<Vertix<T>>> SCC = new ArrayList<ArrayList<Vertix<T>>>();
		while (!stack.isEmpty()) {
			ArrayList<Vertix<T>> component = new ArrayList<Vertix<T>>();
			search(stack.get(0), list, false);

			// any components we visited are strongly connected
			// remove them from the stack and add them to the component
			for (Iterator<Vertix<T>> it = stack.iterator(); it.hasNext();) {
				Vertix<T> n = it.next();
				if (!n.isVisited()) {
					component.add(n);
					it.remove();
				}
			}

			// add the component to the result set
			SCC.add(component);
		}
		return SCC;
	}

	private void search(Vertix<T> root, AdjacencyList<T> list, boolean forward) {
		root.setVisited(forward);

		if (list.getAdjacent(root) == null) {
			if (forward)
				stack.add(0, root);
			return;
		}
		for (Vertix<T> e : list.getAdjacent(root)) {
			if (e.to.visited != forward) {
				search(e.to, list, forward);
			}
		}
		if (forward)
			stack.add(0, root);
	}
}
