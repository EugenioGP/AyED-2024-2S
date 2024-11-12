import org.junit.Test;
import tp5.Recorridos;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio1.adjList.AdjListVertex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void testBFS() {
        Graph<String> graph = new AdjListGraph<>();
        graph.createVertex("A");//0
        graph.createVertex("B");//1
        graph.createVertex("C");//2
        graph.createVertex("D");//3
        graph.createVertex("H");//4
        graph.createVertex("F");//5
        graph.createVertex("G");//6
        graph.connect(graph.getVertex(1), graph.getVertex(0)); //B -> A
        graph.connect(graph.getVertex(1), graph.getVertex(2)); //B -> C
        graph.connect(graph.getVertex(2), graph.getVertex(3)); //C -> D
        graph.connect(graph.getVertex(4), graph.getVertex(6)); //G -> D
        graph.connect(graph.getVertex(4), graph.getVertex(5)); //G -> F

        Recorridos<String> recorridos = new Recorridos<>();
        recorridos.bfs(graph, 1);
    }

    @Test
    public void testKOSARAJU() {
        Graph<String> graph = new AdjListGraph<>();
        graph.createVertex("C");//0
        graph.createVertex("B");//1
        graph.createVertex("H");//2
        graph.createVertex("F");//3
        graph.createVertex("S");//4
        graph.connect(graph.getVertex(0), graph.getVertex(1)); //C -> B
        graph.connect(graph.getVertex(1), graph.getVertex(4)); //B -> S
        graph.connect(graph.getVertex(4), graph.getVertex(0)); //S -> C
        graph.connect(graph.getVertex(3), graph.getVertex(0)); //F -> C
        graph.connect(graph.getVertex(3), graph.getVertex(4)); //F -> S
        graph.connect(graph.getVertex(2), graph.getVertex(1)); //H -> B
        graph.connect(graph.getVertex(2), graph.getVertex(3)); //H -> F

        Recorridos<String> recorridos = new Recorridos<>();
        List<List<Vertex<String>>> vertices0 = recorridos.kosaraju(graph, 0);
        List<List<Vertex<String>>> vertices1 = recorridos.kosaraju(graph, 1);
        List<List<Vertex<String>>> vertices2 = recorridos.kosaraju(graph, 2);
        List<List<Vertex<String>>> vertices3 = recorridos.kosaraju(graph, 3);
        List<List<Vertex<String>>> vertices4 = recorridos.kosaraju(graph, 4);
        assert  vertices0.get(0).size() == 1 && vertices0.get(0).stream().map(Vertex::getData).toList().contains("H");
        assert  vertices0.get(1).size() == 1 && vertices0.get(1).stream().map(Vertex::getData).toList().contains("F");
        assert  vertices0.get(2).size() == 3;
        assert  vertices0.get(2).stream().map(Vertex::getData).toList().contains("C");
        assert  vertices0.get(2).stream().map(Vertex::getData).toList().contains("S");
        assert  vertices0.get(2).stream().map(Vertex::getData).toList().contains("B");
        //------------
        assert  vertices1.get(0).size() == 1 && vertices1.get(0).stream().map(Vertex::getData).toList().contains("H");
        assert  vertices1.get(1).size() == 1 && vertices1.get(1).stream().map(Vertex::getData).toList().contains("F");
        assert  vertices1.get(2).size() == 3;
        assert  vertices1.get(2).stream().map(Vertex::getData).toList().contains("C");
        assert  vertices1.get(2).stream().map(Vertex::getData).toList().contains("S");
        assert  vertices1.get(2).stream().map(Vertex::getData).toList().contains("B");
        //------------
        assert  vertices2.get(0).size() == 1 && vertices2.get(0).stream().map(Vertex::getData).toList().contains("H");
        assert  vertices2.get(1).size() == 1 && vertices2.get(1).stream().map(Vertex::getData).toList().contains("F");
        assert  vertices2.get(2).size() == 3;
        assert  vertices2.get(2).stream().map(Vertex::getData).toList().contains("C");
        assert  vertices2.get(2).stream().map(Vertex::getData).toList().contains("S");
        assert  vertices2.get(2).stream().map(Vertex::getData).toList().contains("B");
        //------------
        assert  vertices3.get(0).size() == 1 && vertices3.get(0).stream().map(Vertex::getData).toList().contains("H");
        assert  vertices3.get(1).size() == 1 && vertices3.get(1).stream().map(Vertex::getData).toList().contains("F");
        assert  vertices3.get(2).size() == 3;
        assert  vertices3.get(2).stream().map(Vertex::getData).toList().contains("C");
        assert  vertices3.get(2).stream().map(Vertex::getData).toList().contains("S");
        assert  vertices3.get(2).stream().map(Vertex::getData).toList().contains("B");
        //------------
        assert  vertices4.get(0).size() == 1 && vertices4.get(0).stream().map(Vertex::getData).toList().contains("H");
        assert  vertices4.get(1).size() == 1 && vertices4.get(1).stream().map(Vertex::getData).toList().contains("F");
        assert  vertices4.get(2).size() == 3;
        assert  vertices4.get(2).stream().map(Vertex::getData).toList().contains("C");
        assert  vertices4.get(2).stream().map(Vertex::getData).toList().contains("S");
        assert  vertices4.get(2).stream().map(Vertex::getData).toList().contains("B");

    }
}
