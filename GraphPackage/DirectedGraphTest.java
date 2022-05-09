package GraphPackage;
import ADTPackage.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectedGraphTest {
    @Test
    void testGetBreadthFirstTraversal() 
    {
        DirectedGraph<String> BreadthTra = new DirectedGraph<>();
        BreadthTra.addVertex("A");
		BreadthTra.addVertex("B");
		BreadthTra.addVertex("C");
		BreadthTra.addVertex("D");
		BreadthTra.addVertex("E");
		BreadthTra.addVertex("F");
		BreadthTra.addVertex("G");
		BreadthTra.addVertex("H");
		BreadthTra.addVertex("I");
		
		//Creating Edges E
		BreadthTra.addEdge("A", "B");
		BreadthTra.addEdge("A", "D");
		BreadthTra.addEdge("A", "E");
		BreadthTra.addEdge("B", "E");
		BreadthTra.addEdge("D", "G");
		BreadthTra.addEdge("E", "F");
		BreadthTra.addEdge("E", "H");
		BreadthTra.addEdge("G", "H");
		BreadthTra.addEdge("F", "C");
		BreadthTra.addEdge("F", "H");
		BreadthTra.addEdge("H", "I");
		BreadthTra.addEdge("C", "B");
		BreadthTra.addEdge("I", "F");
        
        QueueInterface<String> bQueue =  BreadthTra.getBreadthFirstTraversal("A");
        assertEquals("ABDEGFHCI", bQueue.returnQueue());
    }

    @Test
    void testGetDepthFirstTraversal() 
    {
        DirectedGraph<String> DepthTra = new DirectedGraph<>();
		
		//Adding Vertices V
		DepthTra.addVertex("A");
		DepthTra.addVertex("B");
		DepthTra.addVertex("C");
		DepthTra.addVertex("D");
		DepthTra.addVertex("E");
		DepthTra.addVertex("F");
		DepthTra.addVertex("G");
		DepthTra.addVertex("H");
		DepthTra.addVertex("I");
		//Adding Edges E
		DepthTra.addEdge("A", "B");
		DepthTra.addEdge("A", "D");
		DepthTra.addEdge("A", "E");
		DepthTra.addEdge("B", "E");
		DepthTra.addEdge("D", "G");
		DepthTra.addEdge("E", "F");
		DepthTra.addEdge("E", "H");
		DepthTra.addEdge("G", "H");
		DepthTra.addEdge("F", "C");
		DepthTra.addEdge("F", "H");
		DepthTra.addEdge("H", "I");
		DepthTra.addEdge("C", "B");
		DepthTra.addEdge("I", "F");
		
		
        QueueInterface<String> dQueue =  DepthTra.getDepthFirstTraversal("A");
        assertEquals("ABEFCHIDG", dQueue.returnQueue());
    }
   
}
