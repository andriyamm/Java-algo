package org.amm.algo.graphs;

import java.util.ArrayList;

/**
 * TODO
 * 
 */
public class KargerMinCut {

	/**
	 * min cut
	 * 
	 * @param graph
	 * @return
	 */
	public long kargerMinCutAlgo(ArrayList<ArrayList<Integer>> graph) {

		int numberOfVertices = graph.size();
		Edge edge = null;
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
	private long countMinCut(ArrayList<ArrayList<Integer>> graph) {
		
		ArrayList<Integer> q = graph.get(0);
		long count = 0;
		
		int v = q.get(0);
		for (int i = 1; i < q.size(); i++) {
			if (v == q.get(i)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * TODO
	 * 
	 * @param graph
	 * @param edge
	 */
	public void mergeTwoVertices(ArrayList<ArrayList<Integer>> graph, Edge edge) {

		int v = edge.getBeginVertix();
		int u = edge.getEndVertix();

		ArrayList<Integer> vv = graph.get(v);
		ArrayList<Integer> uu = graph.get(u);
		ArrayList<Integer> rr = new ArrayList<Integer>();

		com(rr, vv, v, u);
		com(rr, uu, v, u);

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
	private void com(ArrayList<Integer> rr, ArrayList<Integer> vv, int v, int u) {

		int j = 0;
		for (int i = 1; i < vv.size(); i++) {
			j = vv.get(i);
			if ((j != vv.get(v)) && (j != vv.get(u))) {
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
	private void refreshGraph(ArrayList<ArrayList<Integer>> graph, Edge edge) {

		int v = edge.getBeginVertix();
		int u = edge.getEndVertix();

		for (ArrayList<Integer> vertices : graph) {
			for (int vertix = 1; vertix < vertices.size(); vertix++) {
				if ((vertix == v) || (vertix == u)) {
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
	public Edge pickRandomEdge(ArrayList<ArrayList<Integer>> graph) {

		Edge edge = new Edge();
		int max = graph.size();

		int beginRandom = randomVertix(max);
		edge.setBeginVertix(beginRandom);

		int endRandom = randomVertix(max);
		while (beginRandom == endRandom) {
			endRandom = randomVertix(max);
		}
		edge.setEndVertix(endRandom);

		return edge;
	}

	/**
	 * TODO
	 * 
	 * @param max
	 * @return
	 */
	public int randomVertix(int max) {
		return (int) (Math.random() * (max));
	}
}
