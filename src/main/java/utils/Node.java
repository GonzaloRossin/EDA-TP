package utils;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private List<Edge> edges;
    private boolean visited;
    private Node previousNode;
    private double minDistance = Double.MAX_VALUE;
    private BusStop busInfo;


    public Node(BusStop busStop) {
        this.busInfo = busStop;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setNotVisited() {
        this.visited = false;
    }

    public void setVisited() {
        this.visited = true;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public int getBusLine() {
        return this.busInfo.getBusLine();
    }

    public String getRouteName() {
        return this.busInfo.getRoute();
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }


    @Override
    public String toString() {
        return this.busInfo.toString();
    }

    @Override
    public int compareTo(Node otherNode) {
        return Double.compare(this.minDistance, otherNode.minDistance);
    }
}