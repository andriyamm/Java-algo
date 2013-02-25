package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.List;

import org.amm.algo.graphs.sd.AdjacencyList;
import org.amm.algo.utils.AlgoFileHelper;
import org.junit.Before;
import org.junit.Test;

public class KosarajuAlgoTest {

	private KosarajuAlgo kosarajuAlgo;

	@Before
	public void setUp() {
		kosarajuAlgo = new KosarajuAlgo();
	}

	@Test
	public void kargerMinCutAlgoTest() {

		AdjacencyList adjacencyList = new AdjacencyList();
		try {
			adjacencyList.setAdjacencies(AlgoFileHelper
					.readDataToMap1("res/scc/t2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find(adjacencyList);
		for(Integer i:result){
			System.out.println(i);
		}
		
		System.out.println();
	}
}
