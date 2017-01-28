package minPath;

public class Vertex implements Comparable<Vertex>{
	public final String CityName;
	public Edge[] adjacencies;	// adjMat
	public double minDistance = Double.POSITIVE_INFINITY;	// INF distance by default
	public Vertex previous; // link to previous Vertex
	
	
	//----------------------------------------------------
	// constructor
	public Vertex(String Name)
	{CityName = Name;} // give city name
	
	//----------------------------------------------------
	//get city name
	public String getName()
	{return CityName;}
	
	//----------------------------------------------------
	// sort vertices by distance
	public int compareTo(Vertex other)
	{return Double.compare(minDistance, other.minDistance);}
	
	//-----------------------------------------------------
	// display Adjmat
	public void displayAdjacencies()
	{
		System.out.println("From " + CityName);
		for (Edge e : adjacencies)
			e.displayEdge();
		
	}
}
