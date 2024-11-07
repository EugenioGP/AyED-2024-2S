import org.junit.Test;
import tp5.Recorridos;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio1.adjList.AdjListVertex;

public class RecorridosTest {

    @Test
    public void testDFS() {
        Graph<String> graph = new AdjListGraph<>();
        graph.createVertex("A");
        graph.createVertex("B");
        graph.createVertex("C");
        graph.createVertex("D");
        graph.connect(graph.getVertex(0), graph.getVertex(1));
        graph.connect(graph.getVertex(1), graph.getVertex(2));
        graph.connect(graph.getVertex(2), graph.getVertex(3));
        graph.connect(graph.getVertex(3), graph.getVertex(1));
        graph.connect(graph.getVertex(3), graph.getVertex(2));
        Recorridos<String> recorridos = new Recorridos<>();
        recorridos.dfs(graph);
    }
}
