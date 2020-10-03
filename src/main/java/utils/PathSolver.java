package utils;

import model.BusInPath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PathSolver {
    Graph graph;
    public PathSolver(Graph graph) {
        this.graph = graph;
    }

    public List<BusInPath> findPath(double fromLat, double fromLng, double toLat, double toLng) {
        graph.resetPreviousNodes();
        graph.resetMinDistanceNodes();
        BusStop origin = new BusStop("Origin", "", "", fromLat, fromLng);
        BusStop end = new BusStop("End", "", "", toLat, toLng);
        graph.addNode(origin);
        graph.addNode(end);
        Node nOrigin = graph.nodes.get(origin);
        Node nEnd = graph.nodes.get(end);

        for(Node currentNode : graph.nodes.values()) {
            if(!currentNode.equals(nOrigin) && !currentNode.equals(nEnd)) {
                double distanceOrigin = HaversineDistance.distance(currentNode.getLatitude(), currentNode.getLongitude(), nOrigin.getLatitude(), nOrigin.getLongitude());
                double distanceEnd = HaversineDistance.distance(currentNode.getLatitude(), currentNode.getLongitude(), nEnd.getLatitude(), nEnd.getLongitude());
                if (distanceOrigin <= 500) {
                    nOrigin.addEdge(new Edge(Graph.calculateWeight(distanceOrigin, FormOfTransport.WALK), currentNode, FormOfTransport.WALK));
                    currentNode.addEdge(new Edge(Graph.calculateWeight(distanceOrigin, FormOfTransport.WALK), nOrigin, FormOfTransport.WALK));
                } else if (distanceEnd <= 200) {
                    nEnd.addEdge(new Edge(Graph.calculateWeight(distanceEnd, FormOfTransport.WALK), currentNode, FormOfTransport.WALK));
                    currentNode.addEdge(new Edge(Graph.calculateWeight(distanceEnd, FormOfTransport.WALK), nEnd, FormOfTransport.WALK));
                }
            }
        }

        graph.computePath(nOrigin);
        List<Node> path = graph.getShortestPathTo(nEnd);
        path.remove(0);
        path.remove(path.size() - 1);
        List<BusInPath> busInPathList = fillBusInPath(path);

        graph.removeNode(nOrigin);
        graph.removeNode(nEnd);
        return busInPathList;
    }


    private List<BusInPath> fillBusInPath(List<Node> path) {
        Node oldNode = path.get(0);
        String oldRoute = oldNode.getRouteName();

        List<BusInPath> busInPathList = new ArrayList<>();
        int i;
        for(i = 1; i < path.size(); i++) {
            Node currentNode = path.get(i);
            String currentRoute = currentNode.getRouteName();
            if(!oldRoute.equals(currentRoute)) {
                Node lastNode = path.get(i - 1);
                busInPathList.add(new BusInPath(oldRoute, oldNode.getLatitude(), oldNode.getLongitude(), lastNode.getLatitude(), lastNode.getLongitude()));
                oldNode = currentNode;
                oldRoute = currentRoute;

            }
        }
        busInPathList.add(new BusInPath(oldRoute, oldNode.getLatitude(), oldNode.getLongitude(), path.get(i - 1).getLatitude(), path.get(i - 1).getLongitude()));
        return busInPathList;
    }
}
