package org.amm.algo.sort.qs;

import java.io.FileNotFoundException;

import org.amm.algo.utils.AlgoHelper;
import org.junit.Test;

public class ps2Test {

	@Test
	public void countNumberOfComparisonsTest() {
		Integer[] array = null;
		try {
			//array = AdaHelper.readArrayFromFile("IntegerArray.txt");
			array = AlgoHelper.readArrayFromFile("qs.txt");
			//array = AdaHelper.readArrayFromFile("qs1.txt");
			//array = AdaHelper.readArrayFromFile("qs.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		QuickSort t = QuickSort.getInstance();
		t.quickSort(array, 0, array.length);

	}
}
