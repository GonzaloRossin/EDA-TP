import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    void testGraph(){
        Graph graph=new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A","D",2);
        graph.addEdge("B","C",3);
        graph.addEdge("C","D",4);
        graph.addEdge("D","B",5);
        System.out.println(graph.toString());
    }
}
