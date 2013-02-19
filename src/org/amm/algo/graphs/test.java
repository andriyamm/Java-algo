package org.amm.algo.graphs;

import java.util.ArrayList;

public class test {

	/**
	 * min cut
	 * 
	 * @param graph
	 * @return
	 */
	public int karger(ArrayList<ArrayList<Integer>> graph){
		
		int n = graph.size();
		
		while(n != 2){
			
		}
		
		return 0;
	}
	
	public void merge(ArrayList<ArrayList<Integer>> graph, int v, int u){
		
		ArrayList<Integer> vv = graph.get(v);
		ArrayList<Integer> uu = graph.get(u);
		
		ArrayList<Integer> rr = new ArrayList<Integer>();
		
		for(int i = 1; i<vv.size(); i++){
			if((i != v)||(i != u)){
				rr.add(vv.get(i));
			}
		}
		
		for(int i = 1; i<uu.size(); i++){
			if((i != v)||(i != u)){
				rr.add(uu.get(i));
			}
		}
		
		change(graph);
		graph.set(v, rr);
		graph.remove(u);
	}

	private void change(ArrayList<ArrayList<Integer>> graph) {
		// TODO Auto-generated method stub
		
	}
	
}
