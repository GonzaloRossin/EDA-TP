import org.junit.jupiter.api.Test;
import utils.Graph;

public class GraphTest {
    @Test
    void testBfs() {
        Graph graph = TestGraphFactory.undirectedUnweightedGraph();
        graph.printBfs("A");
    }

    @Test
    void testDfs() {
        Graph graph = TestGraphFactory.undirectedUnweightedGraph();
        graph.printDfs("A");
    }
    @Test
    void testDijkstra() {
        Graph graph = TestGraphFactory.directedUnweightedGraph();
        graph.computePath(graph.nodes.get("A"));
        System.out.println(graph.getShortestPathTo(graph.nodes.get("F")));
    }
}
