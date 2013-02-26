package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class KosarajuAlgoTest {

	private KosarajuAlgo kosarajuAlgo;

	@Before
	public void setUp() {
		kosarajuAlgo = new KosarajuAlgo();
	}

	@Test
	public void kargerMinCutAlgo_t2_Test() {

		try {
			kosarajuAlgo.init("res/scc/t2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<Integer, ArrayList<Integer>> scc = kosarajuAlgo.findSCCs();
		List<Integer> result = kosarajuAlgo.findSizeOfEachComponent(scc);
		for(Integer i:result){
			System.out.println(i);
		}
		System.out.println();
	}
	
	@Test
	public void kargerMinCutAlgo_t4_Test() {

		try {
			kosarajuAlgo.init("res/scc/t4.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<Integer, ArrayList<Integer>> scc = kosarajuAlgo.findSCCs();
		List<Integer> result = kosarajuAlgo.findSizeOfEachComponent(scc);
		for(Integer i:result){
			System.out.println(i);
		}
		System.out.println();
	}
	
	@Test
	public void kargerMinCutAlgo_t5_Test() {

		try {
			kosarajuAlgo.init("res/scc/t5.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<Integer, ArrayList<Integer>> scc = kosarajuAlgo.findSCCs();
		List<Integer> result = kosarajuAlgo.findSizeOfEachComponent(scc);
		for(Integer i:result){
			System.out.println(i);
		}
		System.out.println();
	}
	
	@Test
	public void kargerMinCutAlgo_t6_Test() {

		try {
			kosarajuAlgo.init("res/scc/t6.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<Integer, ArrayList<Integer>> scc = kosarajuAlgo.findSCCs();
		List<Integer> result = kosarajuAlgo.findSizeOfEachComponent(scc);
		for(Integer i:result){
			System.out.println(i);
		}
		System.out.println();
	}
	
	@Test
	public void kargerMinCutAlgo_t7_Test() {

		try {
			kosarajuAlgo.init("res/scc/t7.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<Integer, ArrayList<Integer>> scc = kosarajuAlgo.findSCCs();
		List<Integer> result = kosarajuAlgo.findSizeOfEachComponent(scc);
		for(Integer i:result){
			System.out.println(i);
		}
		System.out.println();
	}
	
	@Test
	public void kargerMinCutAlgoTest() {

		try {
			kosarajuAlgo.init("res/scc/t.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<Integer, ArrayList<Integer>> scc = kosarajuAlgo.findSCCs();
		List<Integer> result = kosarajuAlgo.findSizeOfEachComponent(scc);
		for(Integer i:result){
			System.out.println(i);
		}
		System.out.println();
	}
}
