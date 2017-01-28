package minPath;

import java.util.List;

public class MinPathMain extends FindMinPath {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// use the example in the Question
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		
		A.adjacencies = new Edge[] {new Edge(B, 10), new Edge(C, 6), new Edge(D, 17)};
		B.adjacencies = new Edge[] {new Edge(A, 10), new Edge(D, 5), new Edge(E, 6)};
		C.adjacencies = new Edge[] {new Edge(D, 11), new Edge(A, 6)};
		D.adjacencies = new Edge[] {new Edge(B, 5), new Edge(C, 11), new Edge(A, 17), new Edge(E, 4)};
		E.adjacencies = new Edge[] {new Edge(B, 6), new Edge(D, 4)};
		
		// find min path between A and D
		
		constructPath(A);// construct path from A to any other Vertex
		List<Vertex> path = getShortestPathTo(E);
		System.out.println("Distance from " + A.getName() + " to " + E.getName() + " is " + E.minDistance);
		System.out.print("Path: ");
	    for(Vertex u : path)
	    	System.out.print(u.getName() + " ");
	    System.out.println("");
		
	}// end of main
}
