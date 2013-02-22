package org.amm.algo.graphs;

import java.util.ArrayList;

import org.amm.algo.utils.AlgoHelper;

/**
 * TODO
 * 
 */
public class KargerMinCut {

	/**
	 * karger's min cut algorithm
	 * 
	 * While there are more than 2 vertices: • pick a remaining edge (u,v)
	 * uniformly at random • merge (or “contract” ) u and v into a single vertex
	 * • remove self-loops return cut represented by final 2 vertices. 8
	 * 
	 * @param graph
	 *            graph represented as adjacenty list
	 * 
	 * @return computed minCut value
	 */
	public long kargerMinCutAlgo(ArrayList<ArrayList<Integer>> graph) {

		int numberOfVertices = graph.size();
		
		// verticiesIndex -  vertex's(ArrayList<Integer>) index in graph arrayList
		SimpleEdge verticiesIndex = null;
		
		// verticiesLabel - vertex label (the first integer value in ArrayList<Integer>)
		SimpleEdge verticiesLabel = new SimpleEdge();
		while (numberOfVertices != 2) {
			verticiesIndex = pickRandomEdge(graph);
			
			verticiesLabel.setBeginVertix(graph.get(verticiesIndex.getBeginVertix()).get(0));
			verticiesLabel.setEndVertix(graph.get(verticiesIndex.getEndVertix()).get(0));
			
			mergeTwoVertices(graph, verticiesIndex);
			refreshGraph(graph, verticiesLabel);
			numberOfVertices--;
		}
		return graph.get(0).size() - 1;
	}

	/**
	 * TODO
	 * 
	 * @param graph
	 * @param edge
	 */
	public void mergeTwoVertices(ArrayList<ArrayList<Integer>> graph, SimpleEdge edge) {

		int v = edge.getBeginVertix();
		int u = edge.getEndVertix();

		ArrayList<Integer> vv = graph.get(v);
		ArrayList<Integer> uu = graph.get(u);
		ArrayList<Integer> rr = new ArrayList<Integer>();

		// TODO
		rr.add(vv.get(0));

		mergingVertexLists(rr, vv, vv.get(0), uu.get(0));
		mergingVertexLists(rr, uu, vv.get(0), uu.get(0));

		graph.set(v, rr);
		graph.remove(u);
	}

	/**
	 * TODO
	 * 
	 * @param rr
	 * @param vv
	 * @param v
	 * @param u
	 */
	private void mergingVertexLists(ArrayList<Integer> rr, ArrayList<Integer> vv, int v, int u) {

		int j = 0;
		for (int i = 1; i < vv.size(); i++) {
			j = vv.get(i);
			if ((j != v) && (j != u)) {
				rr.add(j);
			}
		}
	}

	/**
	 * TODO
	 * 
	 * @param graph
	 * @param edge
	 */
	private void refreshGraph(ArrayList<ArrayList<Integer>> graph, SimpleEdge edge) {

		int v = edge.getBeginVertix();
		int u = edge.getEndVertix();

		for (ArrayList<Integer> vertices : graph) {
			for (int vertix = 1; vertix < vertices.size(); vertix++) {
				if (vertices.get(vertix) == u) {
					vertices.set(vertix, v);
				}
			}
		}
	}

	/**
	 * 
	 * @param graph
	 * @return
	 */
	public SimpleEdge pickRandomEdge(ArrayList<ArrayList<Integer>> graph) {

		SimpleEdge edge = new SimpleEdge();
		int max = graph.size();

		int beginRandomIndex = AlgoHelper.randomNumber(0, max);
		ArrayList<Integer> t = graph.get(beginRandomIndex);

		int randomVertix = AlgoHelper.randomNumber(1, t.size());
		int randomIndex = findEndIndex(graph, t.get(randomVertix));

		if (beginRandomIndex < randomIndex) {
			edge.setBeginVertix(beginRandomIndex);
			edge.setEndVertix(randomIndex);
		} else {
			edge.setBeginVertix(randomIndex);
			edge.setEndVertix(beginRandomIndex);
		}

		return edge;

	}

	/**
	 * TODO
	 * 
	 * @param graph
	 * @param key
	 * @return
	 */
	private int findEndIndex(ArrayList<ArrayList<Integer>> graph, int key) {

		int start = 0;
		int end = graph.size() - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key < graph.get(mid).get(0)){
				end = mid - 1;
			}
			else if (key > graph.get(mid).get(0)){
				start = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

}
