package graph;

import java.util.HashSet;
import java.util.Set;

public class Graph<T> {
	boolean isOriented;
	Set<Node<T>> nodes = new HashSet<>();

	public Set<Node<T>> getNodes() {
		return nodes;
	}

	public Graph(boolean isOriented) {
		this.isOriented = isOriented;
	}

	public void addEdge(Node<T> src, Node<T> dest, int weight) {
		nodes.add(src);
		nodes.add(dest);
		src.addEdge(new Edge<>(src, dest, weight));
		if (!isOriented) {
			dest.addEdge(new Edge<>(dest, src, weight));
		}
	}
}
