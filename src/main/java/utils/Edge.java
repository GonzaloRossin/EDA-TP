package utils;

public class Edge {
    private double weight;
    private final FormOfTransport transportType;
    private Node startNode;
    private Node targetNode;

    public Edge(double weight, Node startNode, Node targetNode,FormOfTransport type) {
        this.weight = weight;
        this.startNode = startNode;
        this.targetNode = targetNode;
        this.transportType=type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public FormOfTransport getTransportType() {
        return transportType;
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public void setTargetVertex(Node targetNode) {
        this.targetNode = targetNode;
    }
}