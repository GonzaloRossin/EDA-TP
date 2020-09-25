import org.junit.jupiter.api.Test;

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
}
