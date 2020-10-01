import utils.BusStop;
import utils.Graph;

public class TestGraphFactory {

    public static Graph undirectedUnweightedGraph() {
        Graph graph = new Graph( false);
        BusStop _26A = new BusStop( "22A", "1520 DEFENSA", "Retiro - Cno. Centenario y Lavalleja",-34.625663, -58.371042);
        BusStop _26B = new BusStop( "22A", "722 REGIMIENTO DE PATRICIOS AV.","Retiro - Cno. Centenario y Lavalleja",-34.636743, -58.369765);
        BusStop _26C = new BusStop( "22A", "324 REGIMIENTO DE PATRICIOS AV.","Retiro - Cno. Centenario y Lavalleja",-34.632942, -58.370332);
        BusStop _69A = new BusStop( "60F", "SANTA MARIA DE LAS CONCHAS 3087", "F - Barracas x Alto San Isidro y Alto Tigre - Rincon de Milberg",-34.415425, -58.601647);
        BusStop _69B = new BusStop( "60F", "CHUBUT 1599-1699", "F - Barracas x Alto San Isidro y Alto Tigre - Rincon de Milberg", -34.405822, -58.597088);
        BusStop _8A = new BusStop( "90A", "2324 MITRE BARTOLOME", "Pza. Constitución - Av. San Martin y Gral. Paz",-34.608512, -58.399578000000005);
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
        Graph graph = new Graph( true);
        BusStop _26A = new BusStop( "22A", "1520 DEFENSA", "Retiro - Cno. Centenario y Lavalleja",-34.625663, -58.371042);
        BusStop _26B = new BusStop( "22A", "722 REGIMIENTO DE PATRICIOS AV.","Retiro - Cno. Centenario y Lavalleja",-34.636743, -58.369765);
        BusStop _26C = new BusStop( "22A", "324 REGIMIENTO DE PATRICIOS AV.","Retiro - Cno. Centenario y Lavalleja",-34.632942, -58.370332);
        BusStop _69A = new BusStop( "60F", "SANTA MARIA DE LAS CONCHAS 3087", "F - Barracas x Alto San Isidro y Alto Tigre - Rincon de Milberg",-34.415425, -58.601647);
        BusStop _69B = new BusStop( "60F", "CHUBUT 1599-1699", "F - Barracas x Alto San Isidro y Alto Tigre - Rincon de Milberg", -34.405822, -58.597088);
        BusStop _8A = new BusStop( "90A", "2324 MITRE BARTOLOME", "Pza. Constitución - Av. San Martin y Gral. Paz",-34.608512, -58.399578000000005);
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