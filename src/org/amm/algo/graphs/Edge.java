package org.amm.algo.graphs;

public class Edge {

	private int beginVertix;
	private int endVertix;

	public Edge() {
		super();
	}

	public Edge(int beginVertix, int endVertix) {
		super();
		this.beginVertix = beginVertix;
		this.endVertix = endVertix;
	}

	public int getBeginVertix() {
		return beginVertix;
	}

	public void setBeginVertix(int beginVertix) {
		this.beginVertix = beginVertix;
	}

	public int getEndVertix() {
		return endVertix;
	}

	public void setEndVertix(int endVertix) {
		this.endVertix = endVertix;
	}

}
