package utils;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private String name;
    private List<Edge> edges;
    private boolean visited;
    private Node previousNode;
    private double minDistance = Double.MAX_VALUE;

    public Node(String name) {
        this.name = name;
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

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Node otherNode) {
        return Double.compare(this.minDistance, otherNode.minDistance);
    }
}