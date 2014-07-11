package assignment6;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class ConnectedComponentFinder {
	public Set<Set<String>> connectedComponents(WeightedGraph g) {
		// TODO implement
		ArrayList<ArrayList<String>> OverList = new ArrayList<ArrayList<String>>();

		for(int i=0;i<g.Vertices.size();i++){
			ArrayList<String> list = new ArrayList<String>();		//bilde TeilListe 
			WeightedGraph.EdgeList e = g.Vertices.get(i).Edges;
			list.add(g.Vertices.get(i).Vertex);						//lege Knoten in TeilListe
			while(e.rest!=null){
				list.add(e.Vertex);									//lege alle von diesem Knoten erreichbaren Knoten in TeilListe
				e=e.rest;
			}
			list.add(e.Vertex);
			OverList.add(list);										//f�ge TeilListe der Liste von Listen hinzu
		}
		boolean merged=true;
		while(merged){											//solange in 1 "Durchlauf" gemerged wurde, merge
			merged=merge(OverList);
		}
		
		Set<Set<String>> result= new HashSet<Set<String>>();	//Umwandlung ArrayList of ArrayLists -> Set of Sets
		for(int i=0;i<OverList.size();i++){
			result.add(new HashSet<String>(OverList.get(i))); 	//Umwandlung ArrayList -> Set
		}
		return result;
	}
	
	public boolean merge(ArrayList<ArrayList<String>> OverList){
		boolean merged=false;
		for(int i=0;i<OverList.size();i++){
			for(int j=0;j<OverList.size();j++){
				if(i==j)continue;
				for(int k=0;k<OverList.get(j).size();k++){
					if(OverList.get(i).contains(OverList.get(j).get(k))){	//wenn es ein Element gibt, welches in 2 Listen existiert
						for(int l=0;l<OverList.get(j).size();l++){
							if(!OverList.get(i).contains(OverList.get(j).get(l)))
								OverList.get(i).add(OverList.get(j).get(l));		//�bernehme alle Elemente aus der 2. in die 1. Liste, die noch nicht in der 1.Liste enthalten sind
						}
						OverList.remove(j);					//l�sche die 2.Liste
						merged=true;						//in diesem "Durchlauf" wurde gemerged 
						break;								//sorgt daf�r aus k-Schleife zu springen(liste j existiert nicht mehr)
					}	
				}
			}	
		}
		return merged;
	}
	
	public static void main(String[] args) {
		GraphFileReader reader = new GraphFileReader();
		
		String path = System.getProperty("user.dir");
		WeightedGraph g = reader.read(path, "cast.action.txt");
		
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
