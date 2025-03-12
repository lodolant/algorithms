
import java.util.Map;
import java.util.Map.Entry;

import graph.Graph;
import graph.GraphAlgorithm;
import graph.Node;
import graph.Pair;

public class MainGraph {

	public MainGraph() {
	}

	public static void main(String[] args) {
		mainDijkstra();
//		mainTarkan();
	}

//	// Méthode principale pour tester l'algorithme
//	public static void mainTarkan() {
//		// Créer un graphe d'exemple
//		Graph graph = new Graph(false);
//		graph.addEdge(0, 1, 4);
//		graph.addEdge(0, 2, 1);
//		graph.addEdge(2, 1, 2);
//		graph.addEdge(1, 3, 5);
//		graph.addEdge(2, 3, 8);
//		graph.addEdge(3, 4, 3);
//
//		// Appliquer l'algorithme de Tarkan
//		Map<Integer, Integer> distances = GraphAlgorithm.tarkanAlgorithm(graph, 0);
//
//		// Afficher les distances minimales depuis le sommet 0
//		for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
//			System.out.println(
//					"Distance depuis le sommet " + 0 + " vers le sommet " + entry.getKey() + " : " + entry.getValue());
//		}
//	}

	public static void mainDijkstra() {
		Graph<String> graph = new Graph<>(false);

		// Add edges (undirected graph)
		Node<String> nodeA = new Node<String>("A");
		Node<String> nodeB = new Node<String>("B");
		Node<String> nodeC = new Node<String>("C");
		Node<String> nodeD = new Node<String>("D");
		Node<String> nodeE = new Node<String>("E");

		graph.addEdge(nodeA, nodeB, 4);
		graph.addEdge(nodeA, nodeC, 1);

		graph.addEdge(nodeB, nodeC, 2);
		graph.addEdge(nodeB, nodeD, 5);

		graph.addEdge(nodeC, nodeD, 8);
		graph.addEdge(nodeC, nodeE, 10);

		graph.addEdge(nodeD, nodeE, 2);

		// Run Dijkstra algorithm
		Map<Node<String>, Pair<Node<String>, Integer>> distances = GraphAlgorithm.dijkstra(graph, nodeA);

		// Print the shortest distances
		System.out.println("Shortest distances from source node " + nodeA.getId() + ":");
		for (Entry<Node<String>, Pair<Node<String>, Integer>> entry : distances.entrySet()) {
			System.out.println(entry.getKey().getId() + " : " + entry.getValue());
		}
	}
}
