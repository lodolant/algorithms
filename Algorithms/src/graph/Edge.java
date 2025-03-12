package graph;

public class Edge<T> {
	Node<T> source;
	Node<T> destination;
	int distance;

	public Edge(Node<T> source, Node<T> destination, int distance) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Edge [destination=" + destination + ", distance=" + distance + "]";
	}
}
