import org.junit.jupiter.api.Test;
import utils.BusStop;
import utils.Graph;

public class GraphTest {
    @Test
    void testBfs() {
        Graph graph = TestGraphFactory.undirectedUnweightedGraph();
        BusStop _26A = new BusStop( "22A", "1520 DEFENSA", "Retiro - Cno. Centenario y Lavalleja",-34.625663, -58.371042);
        graph.printBfs(_26A);
    }

    @Test
    void testDfs() {
        Graph graph = TestGraphFactory.undirectedUnweightedGraph();
        BusStop _26A = new BusStop( "22A", "1520 DEFENSA", "Retiro - Cno. Centenario y Lavalleja",-34.625663, -58.371042);
        graph.printDfs(_26A);
    }
    @Test
    void testDijkstra() {
        Graph graph = TestGraphFactory.directedUnweightedGraph();
        BusStop _26A = new BusStop( "22A", "1520 DEFENSA", "Retiro - Cno. Centenario y Lavalleja",-34.625663, -58.371042);
        graph.computePath(graph.nodes.get(_26A));
        BusStop _69B = new BusStop( "60F", "CHUBUT 1599-1699", "F - Barracas x Alto San Isidro y Alto Tigre - Rincon de Milberg", -34.405822, -58.597088);

        System.out.println(graph.getShortestPathTo(graph.nodes.get(_69B)));
    }
}
