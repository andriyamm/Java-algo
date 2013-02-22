package org.amm.algo.graphs.sd;

public class WeightedEdge<T> extends Edge<T> implements Comparable<Edge<T>>{

	private int weight;
	
	public WeightedEdge() {
		super();
	}

	public WeightedEdge(Vertix<T> from, Vertix<T> to, int weight) {
		super(from, to);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
