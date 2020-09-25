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

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");
        graph.addEdge("E", "G");

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

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("C", "F");
        graph.addEdge("F", "E");
        graph.addEdge("E", "G");

        return graph;
    }
}