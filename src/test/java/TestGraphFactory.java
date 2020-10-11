
import utils.FormOfTransport;
import utils.Graph;
import utils.Stop;
import utils.StopType;

public class TestGraphFactory {

    public static Graph directedUnweightedGraph() {
        Graph graph = new Graph();
        Stop origin = new Stop( "Origin", "",-34.625663, -58.371042, StopType.NONE);
        Stop _26A = new Stop( "22A", "722 REGIMIENTO DE PATRICIOS AV.",-34.636743, -58.369765, StopType.BUS);
        Stop _26B = new Stop( "22A", "324 REGIMIENTO DE PATRICIOS AV.",-34.632942, -58.370332, StopType.BUS);
        Stop _69A = new Stop( "60F", "SANTA MARIA DE LAS CONCHAS 3087",-34.415425, -58.601647, StopType.BUS);
        Stop _69B = new Stop( "60F", "CHUBUT 1599-1699", -34.405822, -58.597088, StopType.BUS);
        Stop end = new Stop( "End", "",-34.608512, -58.399578000000005,StopType.NONE);
        graph.addNode(origin);
        graph.addNode(_26A);
        graph.addNode(_26B);
        graph.addNode(_69A);
        graph.addNode(_69B);
        graph.addNode(end);

        graph.addEdge(graph.nodes.get(origin), graph.nodes.get(_26A), Graph.calculateWeight(origin.distance(_26A), FormOfTransport.WALK), FormOfTransport.WALK);
        graph.addEdge(graph.nodes.get(origin), graph.nodes.get(_69A), Graph.calculateWeight(origin.distance(_69A), FormOfTransport.WALK), FormOfTransport.WALK);
        graph.addEdge(graph.nodes.get(_26A), graph.nodes.get(_26B), Graph.calculateWeight(_26A.distance(_26B), FormOfTransport.BUS), FormOfTransport.BUS);
        graph.addEdge(graph.nodes.get(_69A), graph.nodes.get(_69B), Graph.calculateWeight(_69A.distance(_69B), FormOfTransport.BUS), FormOfTransport.BUS);
        graph.addEdge(graph.nodes.get(_69B), graph.nodes.get(end), Graph.calculateWeight(_69B.distance(end), FormOfTransport.WALK), FormOfTransport.WALK);
        graph.addEdge(graph.nodes.get(_26B), graph.nodes.get(end), Graph.calculateWeight(_26B.distance(end), FormOfTransport.WALK), FormOfTransport.WALK);

        return graph;
    }
}