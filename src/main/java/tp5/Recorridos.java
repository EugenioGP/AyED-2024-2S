package tp5;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recorridos<T> {

    public List<T> dfs(Graph<T> graph) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        for (Vertex<T> vertex : graph.getVertices()) {
            if (!visited[vertex.getPosition()]) {
                dfsRecursive(graph, vertex, visited);
            }
        }
        return new ArrayList<>();
    }
    private void dfsRecursive(Graph<T> graph, Vertex<T> vertex, boolean[] visited) {
        if (!visited[vertex.getPosition()]) {
            visited[vertex.getPosition()] = true;
            System.out.println(vertex.getData());
            for (Edge<T> edge: graph.getEdges(vertex)) {
                dfsRecursive(graph, edge.getTarget(), visited);
            }
        }
    }
}
