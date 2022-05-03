

import java.util.Stack;

import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.LinkedDictionary;
import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;
import GraphPackage.VertexInterface;
import GraphPackage.Vertex;

import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;


public class DepthTraversal<T> 
{
    private int edgeCount=0;
    private T vertices;
    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder= new LinkedQueue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);

        while(!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex= vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
            
            if (nextNeighbor != null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else
            {
                vertexStack.pop();
            }

        }
        return traversalOrder;

    }
    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext())
            {
                  VertexInterface<T> nextVertex = vertexIterator.next();
                  nextVertex.unvisit();
                  nextVertex.setCost(0);
                  nextVertex.setPredecessor(null);
            } // end while
    } // end resetVertices
    public boolean isEmpty()
        {
            return vertices.isEmpty();
        } // end isEmpty

    public void clear()
        {
          vertices.clear();
          edgeCount = 0;
        } // end clear

    public int getNumberOfVertices()
        {
            return vertices.getSize();
        } // end getNumberOfVertices

    public int getNumberOfEdges()
     {
        return edgeCount;
     } // end getNumberOfEdges
     
        public boolean addVertex(T vertexLabel)
        {
           VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
           return addOutcome == null; // Was addition to dictionary successful?
        } // end addVertex
        




    
    
}

