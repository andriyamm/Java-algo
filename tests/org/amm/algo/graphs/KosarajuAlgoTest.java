package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.amm.algo.graphs.sd.AdjacencyList;
import org.amm.algo.graphs.sd.Vertix;
import org.amm.algo.utils.AlgoFileHelper;
import org.junit.Before;
import org.junit.Test;

public class KosarajuAlgoTest {

	private KosarajuAlgo<Integer> kosarajuAlgo;

	@Before
	public void setUp() {
		kosarajuAlgo = new KosarajuAlgo<Integer>();
	}

	@Test
	public void kargerMinCutAlgoTest() {

		AdjacencyList<Integer> adjacencyList = new AdjacencyList<Integer>();
		try {
			adjacencyList.setAdjacencies(AlgoFileHelper
					.readDataToMap1("res/scc/t2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Integer> result = kosarajuAlgo.find(adjacencyList, 5);
		for(Integer i:result){
			System.out.println(i);
		}
		
		System.out.println();
	}
}
