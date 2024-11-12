package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class AdjListVertex<T> implements Vertex<T> {
	private T data;
	private int position;
	private List<Edge<T>> edges;
	
	/**
	 *  Constructor del vértices. Solamente se crean desde el grafo. 
	 */
	AdjListVertex(T data, int position) {
		this.data = data;
		this.position = position;
		this.edges = new ArrayList<>();
	}
	
	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int getPosition() {
		return this.position;
	}
	
	void decrementPosition() {
		this.position--;
	}

	void connect(Vertex<T> destination) {
		this.connect(destination, 1);
	}

	void connect(Vertex<T> destination, int weight) {
		Edge<T> edge = this.getEdge(destination);
		if (edge == null) {
			// se crea solo si no existe
			this.edges.add(new AdjListEdge<>(destination, weight));
		}
	}

	void disconnect(Vertex<T> destination) {
		Edge<T> edge = this.getEdge(destination);
		if (edge != null) {
			this.edges.remove(edge);
		}
	}

	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	/**
	 * Retorna, si es que existe, la arista hacia el vertice recibido.
	 */
	public Edge<T> getEdge(Vertex<T> destination) {
		for (Edge<T> edge : this.edges) {
			if (edge.getTarget() == destination) {
				return edge;
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// Check if the object is the same
		if (this == obj) {
			return true;
		}

		// Check if the object is an instance of AdjListVertex
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		// Cast the object to AdjListVertex
		AdjListVertex<?> other = (AdjListVertex<?>) obj;

		// Compare the data of both vertices
		return Objects.equals(this.data, other.data);
	}

	@Override
	public int hashCode() {
		// Generate hash code based on the data
		return Objects.hash(data);
	}
}
