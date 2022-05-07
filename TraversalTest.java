package GraphPackage;
import ADTPackage.*;

public class TraversalTest<T> {
	
	public static void main(String[] args) {
		//The graph: {V, E} where V={ A, B, C, D, E, F, G, H, I }, E = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }
		
		//BreadthFirstTraversal
		DirectedGraph<String> bfsGraph = new DirectedGraph<>();
		
		//Adding Vertices V
		bfsGraph.addVertex("A");
		bfsGraph.addVertex("B");
		bfsGraph.addVertex("C");
		bfsGraph.addVertex("D");
		bfsGraph.addVertex("E");
		bfsGraph.addVertex("F");
		bfsGraph.addVertex("G");
		bfsGraph.addVertex("H");
		bfsGraph.addVertex("I");
		
		//Creating Edges E
		bfsGraph.addEdge("A", "B");
		bfsGraph.addEdge("A", "D");
		bfsGraph.addEdge("A", "E");
		bfsGraph.addEdge("B", "E");
		bfsGraph.addEdge("D", "G");
		bfsGraph.addEdge("E", "F");
		bfsGraph.addEdge("E", "H");
		bfsGraph.addEdge("G", "H");
		bfsGraph.addEdge("F", "C");
		bfsGraph.addEdge("F", "H");
		bfsGraph.addEdge("H", "I");
		bfsGraph.addEdge("C", "B");
		bfsGraph.addEdge("I", "F");
		
		QueueInterface<String> bfsQueue = bfsGraph.getBreadthFirstTraversal("A");
		System.out.println("\n\nBreadth First Traversal of graph: ");
		bfsQueue.printQueue();
		System.out.println();
		
		//DepthFirstTraversal
		DirectedGraph<String> dfsGraph = new DirectedGraph<>();
		
		//Adding Vertices V
		dfsGraph.addVertex("A");
		dfsGraph.addVertex("B");
		dfsGraph.addVertex("C");
		dfsGraph.addVertex("D");
		dfsGraph.addVertex("E");
		dfsGraph.addVertex("F");
		dfsGraph.addVertex("G");
		dfsGraph.addVertex("H");
		dfsGraph.addVertex("I");
		//Adding Edges E
		dfsGraph.addEdge("A", "B");
		dfsGraph.addEdge("A", "D");
		dfsGraph.addEdge("A", "E");
		dfsGraph.addEdge("B", "E");
		dfsGraph.addEdge("D", "G");
		dfsGraph.addEdge("E", "F");
		dfsGraph.addEdge("E", "H");
		dfsGraph.addEdge("G", "H");
		dfsGraph.addEdge("F", "C");
		dfsGraph.addEdge("F", "H");
		dfsGraph.addEdge("H", "I");
		dfsGraph.addEdge("C", "B");
		dfsGraph.addEdge("I", "F");
		
		QueueInterface<String> dfsQueue = dfsGraph.getDepthFirstTraversal("A");
		System.out.println("Depth First Traversal of graph: ");
		dfsQueue.printQueue();
		
	}
	
}
