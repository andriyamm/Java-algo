package org.amm.algo.graphs.scc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.amm.algo.graphs.sd.IEdge;

public class AdjacencyList {

	private Map<Integer, Set<Integer>> adjacencies = new HashMap<Integer, Set<Integer>>();

	public void addEdge(Integer from, Integer to) {
		Set<Integer> set;
		if (!adjacencies.containsKey(from)) {
			set = new HashSet<Integer>();
			adjacencies.put(from, set);
		} else {
			set = adjacencies.get(from);
		}
		set.add(to);
	}

	public void addEdge(IEdge edge) {
		// TODO
	}

	/**
	 * 
	 * @param Integer
	 * @param mark
	 */
	public void markInteger(Integer Integer, boolean mark){
		if(adjacencies.containsKey(Integer)){
			//adjacencies.keySet().is;
		}
		
	}
	
	public Set<Integer> getAdjacent(Integer source) {
		return adjacencies.get(source);
	}

	// public void reverseEdge(IEdge edge) {
	// adjacencies.get(edge.getFrom()).remove(edge);
	// addEdge(edge.getTo(), edge.getFrom());
	// }

	public void reverseGraph() {
		adjacencies = getReversedList().adjacencies;
	}

	public AdjacencyList getReversedList() {
		AdjacencyList newlist = new AdjacencyList();
		for (Entry<Integer, Set<Integer>> entry : adjacencies.entrySet()) {
			Integer from = entry.getKey();
			for (Integer to : entry.getValue()) {
				newlist.addEdge(to, from);
			}
		}
		return newlist;
	}

	public Set<Integer> getSourceIntegerSet() {
		return adjacencies.keySet();
	}

	// public Collection<IEdge> getAllEdges() {
	// List<IEdge> edges = new ArrayList<IEdge>();
	// for (List<IEdge> e : adjacencies.values()) {
	// edges.addAll(e);
	// }
	// return edges;
	// }
	
	public Integer getRandomInteger(){
		//TODO
		return new Integer(1);
		//return adjacencies.keySet().iterator().next();
	}
	
	public void printList(){
		for (Entry<Integer, Set<Integer>> entry : adjacencies.entrySet()) {
			Integer from = entry.getKey();
			System.out.print(from + ":\t");
			for (Integer to : entry.getValue()) {
				System.out.print(to + " ");
			}
			System.out.println();
		}
	}
	
	public Map<Integer, Set<Integer>> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(Map<Integer, Set<Integer>> adjacencies) {
		this.adjacencies = adjacencies;
	}

}
