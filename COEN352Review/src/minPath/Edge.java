package minPath;

public class Edge {
	public final Vertex target;	//target city
	public final double distance; // distance of between two city
	
	//--------------------------------------------------------
	// constructor
	public Edge(Vertex tarCity, double dist)
	{target = tarCity; distance = dist;}
	
	//--------------------------------------------------------
	// display Edge
	public void displayEdge()
	{
		System.out.println("To " + target.getName() + distance + "km");
	}    
}
