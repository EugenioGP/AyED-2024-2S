import org.junit.Before;
import org.junit.Test;
import tp5.Recorridos;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio1.Vertex;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KosarajuTest {

    private Graph<String> graph;
    Recorridos<String> recorridos;

    @Before
    public void setUp() {
        // This should be replaced with your actual graph implementation.
        graph = new AdjListGraph<>();
        recorridos = new Recorridos<>();
    }

    @Test
    public void testSingleVertex() {
        Vertex<String> v1 = graph.createVertex("A");
        List<List<Vertex<String>>> sccs = recorridos.kosaraju(graph, 0);
        assertEquals(1, sccs.size(), "There should be one SCC.");
        assertTrue(sccs.get(0).contains(v1), "SCC should contain vertex A.");
    }

    @Test
    public void testTwoConnectedVertices() {
        Vertex<String> v1 = graph.createVertex("A");
        Vertex<String> v2 = graph.createVertex("B");
        graph.connect(v1, v2); // Create edge A -> B

        List<List<Vertex<String>>> sccs = recorridos.kosaraju(graph, 0);
        assertEquals(2, sccs.size(), "There should be one SCC.");
        assertTrue(sccs.get(0).contains(v1), "SCC should contain vertex A.");
        assertTrue(sccs.get(1).contains(v2), "SCC should contain vertex B.");
    }

    @Test
    public void testTwoDisconnectedVertices() {
        Vertex<String> v1 = graph.createVertex("A");
        Vertex<String> v2 = graph.createVertex("B");

        List<List<Vertex<String>>> sccs = recorridos.kosaraju(graph, 1);
        assertEquals(2, sccs.size(), "There should be two SCCs.");
        assertTrue(sccs.get(0).contains(v1), "SCC should contain vertex A.");
        assertTrue(sccs.get(1).contains(v2), "SCC should contain vertex B.");
    }

    @Test
    public void testCycle() {
        Vertex<String> v1 = graph.createVertex("A");
        Vertex<String> v2 = graph.createVertex("B");
        Vertex<String> v3 = graph.createVertex("C");
        graph.connect(v1, v2);
        graph.connect(v2, v3);
        graph.connect(v3, v1); // Create cycle A -> B -> C -> A

        List<List<Vertex<String>>> sccs = recorridos.kosaraju(graph, 0);
        assertEquals(1, sccs.size(), "There should be one SCC.");
        assertTrue(sccs.get(0).contains(v1), "SCC should contain vertex A.");
        assertTrue(sccs.get(0).contains(v2), "SCC should contain vertex B.");
        assertTrue(sccs.get(0).contains(v3), "SCC should contain vertex C.");
    }

    @Test
    public void testMultipleSCCs() {
        Vertex<String> v1 = graph.createVertex("A");
        Vertex<String> v2 = graph.createVertex("B");
        Vertex<String> v3 = graph.createVertex("C");
        Vertex<String> v4 = graph.createVertex("D");
        graph.connect(v1, v2);
        graph.connect(v2, v1); // Cycle A <-> B
        graph.connect(v3, v4); // Separate component C -> D

        List<List<Vertex<String>>> sccs = recorridos.kosaraju(graph, 2);
        assertEquals(3, sccs.size(), "There should be two SCCs.");
        assertTrue(sccs.get(0).contains(v1), "SCC should contain vertex A.");
        assertTrue(sccs.get(0).contains(v2), "SCC should contain vertex B.");
        assertTrue(sccs.get(1).contains(v3), "SCC should contain vertex C.");
        assertTrue(sccs.get(2).contains(v4), "SCC should contain vertex D.");
    }
}