package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

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

		Map<Vertix<Integer>, Set<Vertix<Integer>>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap1("res/kosaraju/t.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		kosarajuAlgo.run(graph);
		
		System.out.println();
	}
}
