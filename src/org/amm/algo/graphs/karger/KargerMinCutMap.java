package org.amm.algo.graphs.karger;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.amm.algo.utils.AlgoHelper;

public class KargerMinCutMap {

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
	public long kargerMinCutAlgo(Map<Integer, ArrayList<Integer>> graph) {

		int numberOfVertices = graph.size();

		SimpleEdge edge = null;
		while (numberOfVertices != 2) {
			edge = pickRandomEdge(graph);

			mergeTwoVertices(graph, edge);
			refreshGraph(graph, edge);
			numberOfVertices--;
		}
		return countMinCut(graph);
	}

	/**
	 * TODO
	 * 
	 * @param graph
	 */
	private long countMinCut(Map<Integer, ArrayList<Integer>> graph) {
		int count = 0;
		for (Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
			count = entry.getValue().size();
		}
		return count;
	}

	/**
	 * TODO
	 * 
	 * @param graph
	 * @param edge
	 */
	public void mergeTwoVertices(Map<Integer, ArrayList<Integer>> graph,
			SimpleEdge edge) {

		int v = edge.getBeginVertix();
		int u = edge.getEndVertix();

		ArrayList<Integer> vv = graph.get(v);
		ArrayList<Integer> uu = graph.get(u);
		ArrayList<Integer> result = new ArrayList<Integer>();

		mergingVertexLists(result, vv, v, u);
		mergingVertexLists(result, uu, v, u);

		graph.put(v, result);
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
	private void mergingVertexLists(ArrayList<Integer> rr,
			ArrayList<Integer> vv, int v, int u) {

		int j = 0;
		for (int i = 0; i < vv.size(); i++) {
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
	private void refreshGraph(Map<Integer, ArrayList<Integer>> graph, SimpleEdge edge) {

		int v = edge.getBeginVertix();
		int u = edge.getEndVertix();

		for (Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
			ArrayList<Integer> vertices = entry.getValue();
			for (int vertix = 0; vertix < vertices.size(); vertix++) {
				if (vertices.get(vertix) == u) {
					vertices.set(vertix, v);
				}
			}
		}
	}

	/**
	 * TODO
	 * 
	 * @param graph
	 * @return
	 */
	public SimpleEdge pickRandomEdge(Map<Integer, ArrayList<Integer>> graph) {

		SimpleEdge edge = new SimpleEdge();
		int max = graph.size();

		int beginRandomIndex = AlgoHelper.randomNumber(0, max);
		Object[] ta = graph.keySet().toArray();
		int beginRandom = (Integer) ta[beginRandomIndex];

		ArrayList<Integer> t = graph.get(beginRandom);

		int endRandomIndex = AlgoHelper.randomNumber(1, t.size());
		int endRandom = t.get(endRandomIndex);

		edge.setBeginVertix(beginRandom);
		edge.setEndVertix(endRandom);

		return edge;

	}

}
