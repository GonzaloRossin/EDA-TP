import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    void testGraph(){
        Graph graph=new Graph(false);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A","D");
        graph.addEdge("B","C");
        graph.addEdge("C","D");
        graph.addEdge("D","B");
    }
    @Test
    void testBFS(){
        Graph graph=new Graph(false);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addEdge("A","C");
        graph.addEdge("A","B");
        graph.addEdge("C","F");
        graph.addEdge("C","D");
        graph.addEdge("B","D");
        graph.addEdge("D","E");
        graph.addEdge("F","E");
        graph.addEdge("E","G");
        graph.printBfs("A");
    }
}
