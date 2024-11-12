package tp5;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;

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
        visited[vertex.getPosition()] = true;
        System.out.println(vertex.getData());
        for (Edge<T> edge: graph.getEdges(vertex)) {
            Vertex<T> target = edge.getTarget();
            if (!visited[target.getPosition()]) {
                dfsRecursive(graph, target, visited);
            }

        }
    }

    public List<List<Vertex<T>>> kosaraju(Graph<T> graph, int initial) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        Stack<Vertex<T>> stack = new Stack<>();
        kosarajuDFS(graph, graph.getVertex(initial), visited, stack);
        //Apply DFS and mark vertex in postorden order with the stack
        for (Vertex<T> vertex : graph.getVertices()) {
            if (!visited[vertex.getPosition()]) {
                kosarajuDFS(graph, vertex, visited, stack);
            }
        }
        Graph<T> newGraph = new AdjListGraph<>();
        //duplicate graph vertices
        for (int i=0; i<graph.getVertices().size(); i++) {
            Vertex<T> vertex = graph.getVertex(i);
            newGraph.createVertex(vertex.getData());
        }
        //Reverse edges connections
        for (int i=0; i<graph.getVertices().size(); i++) {
            Vertex<T> vertex = newGraph.getVertex(i);
            for (Edge<T> edge : graph.getEdges(graph.getVertex(vertex.getPosition()))) {
                newGraph.connect(newGraph.getVertex(edge.getTarget().getPosition()), vertex);
            };

        }

        boolean[] visited2 = new boolean[graph.getVertices().size()];
        List<List<Vertex<T>>> expansionTrees = new ArrayList<>();
        //do a DFS in the postorden we got from first step, this dfs returns a list of the connected vertices
        while (!stack.isEmpty()) {
            Vertex<T> vertex = newGraph.getVertex(stack.pop().getPosition());
            if (!visited2[vertex.getPosition()]) {
                expansionTrees.add(dfsExpansionTree(newGraph, vertex, visited2));
            }
        }
        //each returned list by the DFS is a connected component
        for(List<Vertex<T>> tree: expansionTrees) {
            for (Vertex<T> vertex2 : tree) {
                System.out.println(vertex2.getData());
            }
            System.out.println("--------------------");
        }
        return expansionTrees;
    }

    private List<Vertex<T>> dfsExpansionTree(Graph<T> graph, Vertex<T> vertex, boolean[] visited) {
        visited[vertex.getPosition()] = true;
        List<Vertex<T>> list = new ArrayList<>(List.of(vertex));
        for (Edge<T> edge: graph.getEdges(vertex)) {
            Vertex<T> target = edge.getTarget();
            if (!visited[target.getPosition()]) {
                list.addAll(dfsExpansionTree(graph, target, visited));
            }
        }
        return list;
    }

    private void kosarajuDFS(Graph<T> graph, Vertex<T> vertex, boolean[] visited, Stack<Vertex<T>> stack) {
        visited[vertex.getPosition()] = true;
        for (Edge<T> edge: graph.getEdges(vertex)) {
            Vertex<T> target = edge.getTarget();
            if (!visited[target.getPosition()]) {
                kosarajuDFS(graph, target, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public List<T> bfs(Graph<T> graph, int initial) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        List<T> bfsList = new ArrayList<>();
        bfs(graph, initial, visited, bfsList);
        for (int i=0; i<graph.getVertices().size(); i++) {
            if (!visited[i]) {
                bfs(graph, i, visited, bfsList);
            }
        }
        return bfsList;
    }

    private static <T> void bfs(Graph<T> graph, int initial, boolean[] visited, List<T> bfsList) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        Vertex<T> origin = graph.getVertices().get(initial);
        queue.add(origin);
        visited[initial] = true;
        bfsList.add(origin.getData());
        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.remove();
            System.out.println(vertex.getData());
            for (Edge<T> edge : graph.getEdges(vertex)) {
                Vertex<T> target = edge.getTarget();
                int targetPosition = target.getPosition();
                if (!visited[targetPosition]) {
                    bfsList.add(graph.getVertex(targetPosition).getData());
                    visited[targetPosition] = true;
                    queue.add(target);
                }
            }
        }
    }


}
