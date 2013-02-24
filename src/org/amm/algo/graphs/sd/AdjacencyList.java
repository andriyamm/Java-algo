package org.amm.algo.graphs.sd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AdjacencyList<T> {

	private Map<Vertix<T>, Set<Vertix<T>>> adjacencies = new HashMap<Vertix<T>, Set<Vertix<T>>>();

	public void addEdge(Vertix<T> from, Vertix<T> to) {
		Set<Vertix<T>> set;
		if (!adjacencies.containsKey(from)) {
			set = new HashSet<Vertix<T>>();
			adjacencies.put(from, set);
		} else {
			set = adjacencies.get(from);
		}
		set.add(to);
	}

	public void addEdge(IEdge<T> edge) {
		// TODO
	}

	public Set<Vertix<T>> getAdjacent(Vertix<T> source) {
		return adjacencies.get(source);
	}

	// public void reverseEdge(IEdge<T> edge) {
	// adjacencies.get(edge.getFrom()).remove(edge);
	// addEdge(edge.getTo(), edge.getFrom());
	// }

	public void reverseGraph() {
		adjacencies = getReversedList().adjacencies;
	}

	public AdjacencyList<T> getReversedList() {
		AdjacencyList<T> newlist = new AdjacencyList<T>();
		for (Entry<Vertix<T>, Set<Vertix<T>>> entry : adjacencies.entrySet()) {
			Vertix<T> from = entry.getKey();
			for (Vertix<T> to : entry.getValue()) {
				newlist.addEdge(to, from);
			}
		}
		return newlist;
	}

	public Set<Vertix<T>> getSourceVertixSet() {
		return adjacencies.keySet();
	}

	// public Collection<IEdge<T>> getAllEdges() {
	// List<IEdge<T>> edges = new ArrayList<IEdge<T>>();
	// for (List<IEdge<T>> e : adjacencies.values()) {
	// edges.addAll(e);
	// }
	// return edges;
	// }
	public Vertix<T> getRandomVertix(){
		//TODO
		return (Vertix<T>) new Vertix<Integer>(1);
	}
	
	public Map<Vertix<T>, Set<Vertix<T>>> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(Map<Vertix<T>, Set<Vertix<T>>> adjacencies) {
		this.adjacencies = adjacencies;
	}

}
