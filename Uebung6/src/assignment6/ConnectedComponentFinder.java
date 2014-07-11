package assignment6;

import java.util.Set;

public class ConnectedComponentFinder {
	public Set<Set<String>> connectedComponents(WeightedGraph g) {
		// TODO implement
		return null;
	}

	public static void main(String[] args) {
		GraphFileReader reader = new GraphFileReader();
		
		WeightedGraph g = reader.read("./", "cast.action.txt");
		
		ConnectedComponentFinder finder = new ConnectedComponentFinder();
		Set<Set<String>> comonentSet = finder.connectedComponents(g);
		System.out.println(comonentSet.size() + " connected components found:");
		
		for(Set<String> c : comonentSet) {
			System.out.print(c.size());
			System.out.print(":\t");
			int i=0;
			for(String el : c) {
				System.out.print(el);
				++i; 
				if(i>5)
					break;
				if(i<c.size()) {
					System.out.print(" & ");
				}
			}
			if(c.size()>5)
				System.out.print(" & ...");
			System.out.println();
		}
	}
}
