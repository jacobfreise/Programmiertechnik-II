package assignment6;
import java.util.ArrayList;

public class WeightedGraph {
	public class Vertex{
		public String Vertex;
		public EdgeList Edges;
	
		Vertex(String from, String to, double weight){
			this.Vertex=from;
			this.Edges.Vertex=to;
			this.Edges.weight=weight;
		}
		Vertex(String vertex){
			this.Vertex=vertex;
		}
	}
	public class EdgeList{
		public String Vertex;
		public double weight; 
		public EdgeList rest;
	
		public double findWeight(String to){
			if(Vertex==to) return weight;
			else{
				if(rest==null) throw new IllegalStateException(); 				//Zugriff auf nicht vorhandene Kante(to) nicht zulässig
				else return rest.findWeight(to);
			}
		}
		public void set(String to, double weight){		//setze ans Ende oder überschreibe
			if(Vertex==to) this.weight=weight;
			else{
				if(rest!=null)
					rest.set(to, weight);
				else{
					this.Vertex=to;
					this.weight=weight;
				}
			}
		}
		public boolean contains(String vertex){		//enthalten in der EdgeList?
			if(this.Vertex==vertex)return true;
			else{
				if(rest==null) return false;
				else return rest.contains(vertex);
			}
		}
	}
	
	public ArrayList<Vertex> Vertices;
	
	public int verticeCount() {		//Anzahl Knoten = Größe der ArrayList Vertices 
		// TODO implement
		return Vertices.size();
	}
	public int edgeCount() {		//Anzahl aller Kanten(Summe der EdgeList-Längen der einzelnen Knoten)
		// TODO implement
		int counter=0;
		for(int i=0;i<Vertices.size();i++){
			if(Vertices.get(i).Edges!=null)counter+=countAllEdges(Vertices.get(i).Edges);
		}
		return counter;
	}
	public int countAllEdges(EdgeList Edges){		//Zählt alle Kanten für gegebenen Knoten bzw deren EdgeList
		if(Edges.rest!=null) return 1 + countAllEdges(Edges.rest);
		else return 1;
	}
	public double weight(String from, String to) {		//findet gesuchte Kante(from, to) und gibt Gewicht aus bzw wirft Exception wenn keine solche Kante vorhanden
		// TODO implement
		int i;
		for(i=0;i<Vertices.size();i++){
			if(Vertices.get(i).Vertex==from){
				return Vertices.get(i).Edges.findWeight(to); 
			}
		}
		throw new IllegalStateException();			//Zugriff auf nicht vorhandene Kante(from) nicht zulässig
	}

	public void add(String from, String to, double weight) {
		// TODO implement
		int i;
		for(i=0;i<Vertices.size();i++){		
			if(Vertices.get(i).Vertex==from) {		//finde from
				Vertices.get(i).Edges.set(to,weight);	//setze Gewicht bei Vertex to
				for(int j=0;j<Vertices.size();j++){
					if(Vertices.get(j).Vertex==to)return;
				}
				Vertex v = new Vertex(to);		//falls to-Knoten nicht Element von Vertices -> füge to-Knoten den Vertices hinzu
				Vertices.add(v);
				return;
			}
		}
		Vertex v = new Vertex(from,to,weight);		//neues from -> neuer Knoten und neue Kante in EdgeList eintragen
		Vertices.add(v);
		
		
	}
	public Iterable<String> vertices() {			//Erzeuge aus Liste von Vertices Liste von Strings, gebe sie zurück
		// TODO implement
		ArrayList<String> VertexList = new ArrayList<String>();
		for(int i=0;i<Vertices.size();i++){
			VertexList.add(Vertices.get(i).Vertex);
		}
		return VertexList;
	}
	public Iterable<String> adjacentOf(String vertex) {		//gibt den Knoten und allle Knoten zu denen er führt in einer Liste zurück
		// TODO implement
		ArrayList<String> a = new ArrayList<String>();
		for(int i=0;i<Vertices.size();i++){
			if(Vertices.get(i).Vertex==vertex){
				for(int j=0;j<Vertices.size();j++){
					if(Vertices.get(i).Edges.contains(Vertices.get(j).Vertex)) a.add("1");
					else a.add("0");
				}
			}
		}
		return a;
	}
	
}
