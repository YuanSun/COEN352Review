package dfs;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts; // current number of vertices;
	private StackX theStack;
	
	// constructor
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j= 0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0;
		theStack = new StackX();
	}// end construcotr
	
	// add vertex
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	// add edge - equal weight
	public void addEdge (int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	// display vertex
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	// dfs
	public void dfs() {
		vertexList[0].wasVisited = true; // begin with vertex 0, mark it
		displayVertex(0); // display it
		theStack.push(0); // push it
		
		while (!theStack.isEmpty()) {
			// get an unvisited vertex adjacent to the stack top
			int v = getAdjUnivisitedVertex(theStack.peek());
			if(v == -1) // if no such vertex
				theStack.pop();
			else {
				vertexList[v].wasVisited = true; // mark it 
				displayVertex(v); // display it
				theStack.push(v); // push it
			}
		}// end while
		
		// stack is empty, so we're done
		for(int j = 0; j < nVerts; j++)
			// reset flags
			vertexList[j].wasVisited = false;
	}// end dfs

	public int getAdjUnivisitedVertex(int v) {
		for(int j = 0; j < nVerts; j++)
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}
}
