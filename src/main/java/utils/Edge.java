package utils;

import java.util.Objects;

public class Edge {
    private double weight;
    private Node targetNode;
    private FormOfTransport transport;

    public Edge(double weight, Node targetNode, FormOfTransport transport) {
        this.weight = weight;
        this.targetNode = targetNode;
        this.transport = transport;
    }

    public double getWeight() {
        return weight;
    }

    public FormOfTransport getTransport() {
        return transport;
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public void setTargetVertex(Node targetNode) {
        this.targetNode = targetNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(edge.weight, weight) == 0 &&
                Objects.equals(targetNode, edge.targetNode) &&
                transport == edge.transport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, targetNode, transport);
    }
}