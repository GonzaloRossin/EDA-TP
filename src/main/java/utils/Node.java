package utils;

import java.util.*;

public class Node implements Comparable<Node> {
    private Set<Edge> edges;
    private boolean visitCheck;
    private Node previousNode;
    private double minDistance = Double.MAX_VALUE;
    private Stop stopInfo;


    public Node(Stop stop) {
        this.stopInfo = stop;
        this.edges = new HashSet<>();
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visitCheck;
    }

    public void setNotVisited() {
        this.visitCheck = false;
    }

    public void setPreviousNodeNull() {
        this.previousNode = null;
    }

    public void setMinDistanceMaxValue() {
        this.minDistance = Double.MAX_VALUE;
    }

    public void setVisited() {
        this.visitCheck = true;
    }

    public void unSetVisited() {
        this.visitCheck = false;
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

    public Stop getStopInfo() {
        return stopInfo;
    }

    public double getLatitude() {
        return this.stopInfo.getLatitude();
    }

    public double getLongitude() {
        return this.stopInfo.getLongitude();
    }

    public String getRouteName() {
        return this.stopInfo.getRoute();
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(stopInfo, node.stopInfo);
    }

    @Override
    public String toString() {
        return this.stopInfo.toString();
    }

    @Override
    public int compareTo(Node otherNode) {
        return Double.compare(this.minDistance, otherNode.minDistance);
    }
}