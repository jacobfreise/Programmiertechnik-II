package assignment6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphFileReader {
	/**
	 * reads the specified graph file and creates a new {@link WeightedGraph} instance based on the data 
	 * @param path the path to the graph file (e.g., <code>./</code>)
	 * @param filename the file name (e.g., <code>cast.action.txt</code>)
	 * @return the new graph instance
	 */
	public WeightedGraph read(String path, String filename) {
		File inputFile = new File(path, filename);
		if (!inputFile.exists()) {
			throw new IllegalArgumentException("Unable to open \"" + inputFile + "\"! File does not exist.");
		}

		WeightedGraph resultGraph = new WeightedGraph();
		int i = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
			String line;
			System.out.print("Reading graph ");
			while (null != (line = reader.readLine())) {
				String[] elements = line.split("\\t");
				if (elements.length > 2) {
					resultGraph.add(elements[0], elements[1], Double.parseDouble(elements[2]));
				}
				if (i++ % 100000 == 0) {
					System.out.print('.');
				}
			}
			System.out.println(" done!");
		} catch (IOException e) {
			throw new IllegalStateException("Unable to read \"" + inputFile + "\"!", e);
		}
		

		return resultGraph;
	}
}
