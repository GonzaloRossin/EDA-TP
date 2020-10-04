import org.junit.jupiter.api.Test;
import utils.Graph;
import utils.Stop;
import utils.StopType;

public class GraphTest {

    @Test
    void testDijkstra() {
        Graph graph = TestGraphFactory.directedUnweightedGraph();
        Stop _26A = new Stop( "22A", "1520 DEFENSA",-34.625663, -58.371042, StopType.NONE);
        graph.computePath(graph.nodes.get(_26A));
        Stop _69B = new Stop( "60F", "CHUBUT 1599-1699", -34.405822, -58.597088,StopType.NONE);

        System.out.println(graph.getShortestPathTo(graph.nodes.get(_69B)));
    }
}
