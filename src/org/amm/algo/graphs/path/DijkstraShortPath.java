package org.amm.algo.graphs.path;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DijkstraShortPath {

	private int[] verticesWeight;
	private PriorityQueue<WeightedEdge> queue;
	private int verticesCount;
	private Map<Integer, List<WeightedEdge>> data = new HashMap<Integer, List<WeightedEdge>>();

	public void init(String filename) {
		try {
			readData(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verticesWeight = new int[verticesCount];
		Arrays.fill(verticesWeight, Integer.MAX_VALUE);

		queue = new PriorityQueue<WeightedEdge>();
	}

	public void run() {
		
		int to = 0, d = 0;

		// first itaration
		int vertix = 1;
		int distance = 0;
		verticesWeight[0] = 0;

		for (WeightedEdge edge : data.get(vertix)) {
			to = edge.getTo();
			d = distance + edge.getWeight();
			if (verticesWeight[to - 1] > d) {
				verticesWeight[to - 1] = d;
				queue.add(edge);
			}
		}
		data.remove(vertix);

		// next iterations
		while (!queue.isEmpty()) {
			if (data.isEmpty()) {
				return;
			}

			WeightedEdge e = queue.poll();
			vertix = e.getTo();
			distance = e.getWeight();

			if (data.containsKey(vertix)) {
				for (WeightedEdge edge : data.get(vertix)) {
					if (!data.containsKey(edge.getTo())) {
						continue;
					}
					to = edge.getTo();
					d = distance + edge.getWeight();
					if (verticesWeight[to - 1] > d) {
						verticesWeight[to - 1] = d;
						edge.setWeight(d);
						queue.add(edge);
					}
				}
				data.remove(vertix);
			}
		}
	}

	/**
	 * 
	 */
	public void print() {
		for (int i = 0; i < verticesWeight.length; i++) {
			System.out.println("i = " + i + " weight = " + verticesWeight[i]);
		}
		System.out.println();
	}

	/**
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void readData(String filename) throws FileNotFoundException {

		int from = 0;
		WeightedEdge edge = null;

		Scanner input = new Scanner(new File(filename));

		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			List<WeightedEdge> row = new ArrayList<WeightedEdge>();
			if (rowReader.hasNextInt()) {

				// first number in row is the vertex label,
				// we will used it as key in map
				from = rowReader.nextInt();
				while (rowReader.hasNext()) {
					int[] toAndWeight = parseSplit(rowReader.next());
					edge = new WeightedEdge(from, toAndWeight[0],
							toAndWeight[1]);
					row.add(edge);
				}
			}
			data.put(from, row);
		}
		verticesCount = from;
	}

	/**
	 * 
	 * @param next
	 * @return
	 */
	private int[] parseSplit(String next) {

		int[] toAndWeight = new int[2];
		int i = 0;
		String[] splitString = (next.split(","));
		for (String s : splitString) {
			toAndWeight[i++] = Integer.parseInt(s);
		}
		return toAndWeight;
	}

	/**
	 * 
	 * @param next
	 * @return
	 */
	@SuppressWarnings("unused")
	private int[] parseMatcher(String next) {

		int[] toAndWeight = new int[2];
		Pattern pattern = Pattern.compile("\\d+");

		int i = 0;
		Matcher matcher = pattern.matcher(next);
		while (matcher.find()) {
			toAndWeight[i++] = Integer.parseInt(matcher.group());
		}

		return toAndWeight;
	}
}
