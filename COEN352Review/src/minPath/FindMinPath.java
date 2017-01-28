package minPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinPath {
	//construct path from source to any other destination
    public static void constructPath(Vertex source)
    {
        source.minDistance = 0.0; // 0 distance to itself
        
        // construct PriorityQueue to store Vertex
        Queue<Vertex> vertexQueue = new LinkedList<Vertex>();
        vertexQueue.add(source); // search from source
        
        // until the queue is empty
        while(!vertexQueue.isEmpty())
        {
        	Vertex u = vertexQueue.poll(); // test the head of vertexQueue
        	
        	//Visit each edge of u, Use breadth-first search to add minDistance
        	for(int i = 0; i < u.adjacencies.length; i++)
        	{
        		Vertex v = u.adjacencies[i].target;
        		double distanceBetweenUandTarget = u.adjacencies[i].distance;
        		double distanceThroughU = u.minDistance + distanceBetweenUandTarget;
        		
        		// update the Min distance to the target and keep the path
        		if(distanceThroughU < v.minDistance)
        		{	
        			//vertexQueue.remove(v); can be removed
        		
        			v.minDistance = distanceThroughU; // update min distance in the target
        			v.previous = u;	//keep the path go through u
        			vertexQueue.add(v); // insert it to queue according to minDistance
        		}// end of if, update 
        	}// end of for loop, bfs
        }//end of while the queue is not empty
    }// end of constructPath
    
    //-------------------------------------------------------------------------------
    // get shortest path to a target city, and return the path
    public static List<Vertex> getShortestPathTo (Vertex target)
    {
    	List<Vertex> path = new ArrayList<Vertex>();
    	
    	Vertex City = target; 
    	//until path search finish
    	while(City != null)
    	{
    		path.add(City);
    		City = City.previous;
    	}
    	
    	// reverse the order of path --> from start to end
    	Collections.reverse(path);
    	
    	return path;
    }// end of getShortestPathTo
}
