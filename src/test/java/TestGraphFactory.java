
import utils.Graph;
import utils.Stop;
import utils.StopType;

public class TestGraphFactory {

    public static Graph undirectedUnweightedGraph() {
        Graph graph = new Graph( );
        Stop _26A = new Stop( "22A", "1520 DEFENSA",-34.625663, -58.371042, StopType.NONE);
        Stop _26B = new Stop( "22A", "722 REGIMIENTO DE PATRICIOS AV.",-34.636743, -58.369765,StopType.NONE);
        Stop _26C = new Stop( "22A", "324 REGIMIENTO DE PATRICIOS AV.",-34.632942, -58.370332,StopType.NONE);
        Stop _69A = new Stop( "60F", "SANTA MARIA DE LAS CONCHAS 3087",-34.415425, -58.601647,StopType.NONE);
        Stop _69B = new Stop( "60F", "CHUBUT 1599-1699", -34.405822, -58.597088,StopType.NONE);
        Stop _8A = new Stop( "90A", "2324 MITRE BARTOLOME",-34.608512, -58.399578000000005,StopType.NONE);
        graph.addNode(_26A);
        graph.addNode(_26B);
        graph.addNode(_26C);
        graph.addNode(_69A);
        graph.addNode(_69B);
        graph.addNode(_8A);

        //graph.addEdge(_26A, _26B, 0);
        //graph.addEdge(_69A, _69B, 0);
        //graph.addEdge(_26B, _69A, 0);
        //graph.addEdge(_69A, _8A, 0);
        return graph;
    }

    public static Graph directedUnweightedGraph() {
        Graph graph = new Graph();
        Stop _26A = new Stop( "22A", "1520 DEFENSA",-34.625663, -58.371042,StopType.NONE);
        Stop _26B = new Stop( "22A", "722 REGIMIENTO DE PATRICIOS AV.",-34.636743, -58.369765,StopType.NONE);
        Stop _26C = new Stop( "22A", "324 REGIMIENTO DE PATRICIOS AV.",-34.632942, -58.370332,StopType.NONE);
        Stop _69A = new Stop( "60F", "SANTA MARIA DE LAS CONCHAS 3087",-34.415425, -58.601647,StopType.NONE);
        Stop _69B = new Stop( "60F", "CHUBUT 1599-1699", -34.405822, -58.597088,StopType.NONE);
        Stop _8A = new Stop( "90A", "2324 MITRE BARTOLOME",-34.608512, -58.399578000000005,StopType.NONE);
        graph.addNode(_26A);
        graph.addNode(_26B);
        graph.addNode(_26C);
        graph.addNode(_69A);
        graph.addNode(_69B);
        graph.addNode(_8A);

        //graph.addEdge(_26A, _26B, 10);
        //graph.addEdge(_69A, _69B, 30);
        //graph.addEdge(_26B, _69A, 50);
        //graph.addEdge(_69A, _8A, 20);

        return graph;
    }
}