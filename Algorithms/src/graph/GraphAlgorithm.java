package graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GraphAlgorithm {

	public static <T> Map<Node<T>, Pair<Node<T>, Integer>> dijkstra(Graph<T> graph, Node<T> source) {
		// Distance from source to each node, initially set to infinity
		Map<Node<T>, Pair<Node<T>, Integer>> distances = new HashMap<>();
		for (Node<T> node : graph.getNodes()) {
			distances.put(node, new Pair<>(node, Integer.MAX_VALUE));
		}
		distances.put(source, new Pair<>(source, 0)); // Distance to source is 0

		// Min-heap priority queue for processing nodes
		PriorityQueue<Node<T>> priorityQueue = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(Node<T> o1, Node<T> o2) {
				return distances.get(o1).second - distances.get(o2).second;
			}
		});
		priorityQueue.add(source);

		while (!priorityQueue.isEmpty()) {
			Node<T> current = priorityQueue.poll();
			System.out.println("Mark " + current);
			// Update neighbors' distances
			for (Edge<T> edge : current.getEdges()) {
				Node<T> neighbor = edge.destination;
				int distance = edge.distance;
				int newDistance = distances.get(current).second + distance;
				int referenceDistance = distances.get(neighbor).second;
				if (newDistance < referenceDistance) {
					distances.put(neighbor, new Pair<>(edge.source, newDistance));
					priorityQueue.add(neighbor);
				}
			}
		}
		return distances;
	}

}
