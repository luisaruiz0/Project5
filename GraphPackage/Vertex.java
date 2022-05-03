package GraphPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*; // Classes that implement various ADTs

/**
 A class of vertices for a graph.
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
class Vertex<T> implements VertexInterface<T>
{
   private T label;
   private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
   private boolean visited;                          // True if visited
   private VertexInterface<T> previousVertex;        // On path to this vertex
   private double cost;                              // Of path to this vertex
   
   public Vertex(T vertexLabel)
   {
      label = vertexLabel;
      edgeList = new LinkedListWithIterator<>();
      visited = false;
      previousVertex = null;
      cost = 0;
   } // end constructor

// Implementations of the vertex operations
   
   public T getLabel() {
		return label;
	}

	public void visit() {
		visited = true;
	}

	public void unvisit() {
		visited = false;		
	}

	public boolean isVisited() {
		return visited;
	}

	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		boolean result = false;

		   if (!this.equals(endVertex))
		   {  // Vertices are distinct
		      Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		      boolean duplicateEdge = false;

		      while (!duplicateEdge && neighbors.hasNext())
		      {
		         VertexInterface<T> nextNeighbor = neighbors.next();
		         if (endVertex.equals(nextNeighbor))
		            duplicateEdge = true;
		      } // end while

		      if (!duplicateEdge)
		      {
		         edgeList.add(new Edge(endVertex, edgeWeight));
		         result = true;
		      } // end if
		   } // end if

		   return result;
	}

	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex, 0);
	}

	
	public Iterator<VertexInterface<T>> getNeighborIterator() {
		return new NeighborIterator();
	}
	
	//NeighborIterator Class
	private class NeighborIterator implements Iterator<VertexInterface<T>>
	{
	   private Iterator<Edge> edges;
	   
	   private NeighborIterator()
	   {
	      edges = edgeList.getIterator();
	   } // end default constructor
	   
	   public boolean hasNext()
	   {
	      return edges.hasNext();
	   } // end hasNext
	   
	   public VertexInterface<T> next()
	   {
	      VertexInterface<T> nextNeighbor = null;
	      
	      if (edges.hasNext())
	      {
	         Edge edgeToNextNeighbor = edges.next();
	         nextNeighbor = edgeToNextNeighbor.getEndVertex();
	      }
	      else
	         throw new NoSuchElementException();
	      
	      return nextNeighbor;
	   } // end next
	   
	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	} 
	// end NeighborIterator Class

	//
	public Iterator<Double> getWeightIterator() {
		/** Creates an iterator of the weights of the edges to this 
	       vertex's neighbors.
	    @return  An iterator of edge weights for edges to neighbors of this
	             vertex. */
		return new weightIterator();
	}
	
	//Weight Iterator Class
	private class weightIterator implements Iterator<Double>
	{
		private Iterator<Edge> edges;
		
		private weightIterator()
		{
			edges = edgeList.getIterator();
		} 
		
		public boolean hasNext() 
		{
			return edges.hasNext();
		} 
		
		public Double next()
		{
			Double edgeWeight = new Double(0);
			
			if (edges.hasNext())
			{
				Edge edgeToNextNeighbor = edges.next();
				edgeWeight = edgeToNextNeighbor.getWeight();
			}
			else
				throw new NoSuchElementException();
		
			return edgeWeight;
		}
		
		public void remove()
		{
		  throw new UnsupportedOperationException();
		} 
	} // end weightIterator 
	

	public boolean hasNeighbor() {
		return !edgeList.isEmpty();
	}

	public VertexInterface<T> getUnvisitedNeighbor()
	{
	   VertexInterface<T> result = null;

	   Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
	   while ( neighbors.hasNext() && (result == null) )
	   {
	      VertexInterface<T> nextNeighbor = neighbors.next();
	      if (!nextNeighbor.isVisited())
	         result = nextNeighbor;
	   } // end while

	   return result;
	} // end getUnvisitedNeighbor

	public void setPredecessor(VertexInterface<T> predecessor) {
		// Records the previous vertex on a path to this vertex.
	    // @param predecessor  The vertex previous to this one along a path.
		previousVertex = predecessor;
	}

	public VertexInterface<T> getPredecessor() {
		/** Gets the recorded predecessor of this vertex.
	       @return  Either this vertex's predecessor or null if no predecessor
	                was recorded. */
		return previousVertex;
	}

	public boolean hasPredecessor() {
		/** Sees whether a predecessor was recorded for this vertex.
	       @return  True if a predecessor was recorded. */
		if (previousVertex != null) {
			return true;
		}
		else
			return false;
	}

	public void setCost(double newCost) {
		/** Records the cost of a path to this vertex.
	       @param newCost  The cost of the path. */
		cost = newCost;
	}

	public double getCost() {
		/** Gets the recorded cost of the path to this vertex.
	       @return  The cost of the path. */
		return cost;
	}
   
   //END OF VERTEX METHOD IMPLEMENTATIONS

   protected class Edge
   {
      private VertexInterface<T> vertex; // Vertex at end of edge
      private double weight;
      
      protected Edge(VertexInterface<T> endVertex, double edgeWeight)
      {
         vertex = endVertex;
         weight = edgeWeight;
      } // end constructor
      
      protected Edge(VertexInterface<T> endVertex)
      {
         vertex = endVertex;
         weight = 0;
      } // end constructor

      protected VertexInterface<T> getEndVertex()
      {
         return vertex;
      } // end getEndVertex
      
      protected double getWeight()
      {
         return weight; 
      } // end getWeight
   } // end Edge

} // end Vertex
