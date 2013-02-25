package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.List;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find();
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find();
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find();
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find();
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find();
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> result = kosarajuAlgo.find();
		
		for(Integer i:result){
			System.out.println(i);
		}
		
		System.out.println();
	}
}
