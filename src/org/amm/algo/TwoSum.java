package org.amm.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSum {
	
	private Set<Integer> table = new HashSet<Integer>();
	private Integer leftBound = 2500;
	private Integer rightBound = 4000;
	
	public void readData(String filename) throws FileNotFoundException{
		int temp = 0;
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			
			if (rowReader.hasNextInt()) {
				temp = rowReader.nextInt();
				
			}
			
		}
	}
	
	public int run(){
		return 0;
	}
}
