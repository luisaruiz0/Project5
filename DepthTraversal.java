import java.util.Vector;
import java.util.Queue;

public class DepthTraversal 
{
    
    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder= new LinkedQueue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin)
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
    
    
}
