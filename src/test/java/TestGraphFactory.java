import utils.Graph;

public class TestGraphFactory {

    public static Graph undirectedUnweightedGraph() {
        Graph graph = new Graph( false);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");

        graph.addEdge("A", "B", 0);
        graph.addEdge("A", "C", 0);
        graph.addEdge("B", "D", 0);
        graph.addEdge("C", "D", 0);
        graph.addEdge("D", "E", 0);
        graph.addEdge("C", "F", 0);
        graph.addEdge("E", "F", 0);
        graph.addEdge("E", "G", 0);

        return graph;
    }

    public static Graph directedUnweightedGraph() {
        Graph graph = new Graph( true);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");

        graph.addEdge("A", "B", 10.0);
        graph.addEdge("A", "C", 20.0);
        graph.addEdge("B", "D", 30.0);
        graph.addEdge("C", "D", 5.0);
        graph.addEdge("D", "E", 2.0);
        graph.addEdge("C", "F", 1.0);
        graph.addEdge("F", "E", 6.0);
        graph.addEdge("E", "G", 4.0);

        return graph;
    }
}