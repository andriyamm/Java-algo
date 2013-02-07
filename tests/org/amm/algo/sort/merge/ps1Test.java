package org.amm.algo.sort.merge;

import java.io.FileNotFoundException;

import org.amm.algo.utils.AlgoHelper;
import org.junit.Test;

public class ps1Test {

	@Test
	public void countNumberOfInversionsTest() {
		Integer[] array = null;
		try {
			array = AlgoHelper.readArrayFromFile("IntegerArray.txt");
			//array = AdaHelper.readArrayFromFile("ia2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
