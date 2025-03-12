package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<T> {

	T id;
	List<Edge<T>> edges = new ArrayList<>();

	public Node(T id) {
		this.id = id;
	}

	public void addEdge(Edge<T> edge) {
		this.edges.add(edge);
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public T getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<?> other = (Node<?>) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Node [id=" + id + "]";
	}
}
