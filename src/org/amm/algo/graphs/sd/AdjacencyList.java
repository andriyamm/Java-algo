package org.amm.algo.graphs.sd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AdjacencyList {

	private Map<Vertix, Set<Vertix>> adjacencies = new HashMap<Vertix, Set<Vertix>>();

	public void addEdge(Vertix from, Vertix to) {
		Set<Vertix> set;
		if (!adjacencies.containsKey(from)) {
			set = new HashSet<Vertix>();
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
	 * @param vertix
	 * @param mark
	 */
	public void markVertix(Vertix vertix, boolean mark){
		if(adjacencies.containsKey(vertix)){
			//adjacencies.keySet().is;
		}
		
	}
	
	public Set<Vertix> getAdjacent(Vertix source) {
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
		for (Entry<Vertix, Set<Vertix>> entry : adjacencies.entrySet()) {
			Vertix from = entry.getKey();
			for (Vertix to : entry.getValue()) {
				newlist.addEdge(to, from);
			}
		}
		return newlist;
	}

	public Set<Vertix> getSourceVertixSet() {
		return adjacencies.keySet();
	}

	// public Collection<IEdge> getAllEdges() {
	// List<IEdge> edges = new ArrayList<IEdge>();
	// for (List<IEdge> e : adjacencies.values()) {
	// edges.addAll(e);
	// }
	// return edges;
	// }
	
	public Vertix getRandomVertix(){
		//TODO
		return new Vertix(1);
		//return adjacencies.keySet().iterator().next();
	}
	
	public void printList(){
		for (Entry<Vertix, Set<Vertix>> entry : adjacencies.entrySet()) {
			Vertix from = entry.getKey();
			System.out.print(from.getName() + ":\t");
			for (Vertix to : entry.getValue()) {
				System.out.print(to.getName() + " ");
			}
			System.out.println();
		}
	}
	
	public Map<Vertix, Set<Vertix>> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(Map<Vertix, Set<Vertix>> adjacencies) {
		this.adjacencies = adjacencies;
	}

}
