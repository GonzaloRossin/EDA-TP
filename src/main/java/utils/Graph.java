package utils;
import java.util.*;

public class Graph {
    private final boolean isDirected;
    public Map<BusStop, Node> nodes;
    final double BUS_SPEED = 16.67;
    final double WALKING_SPEED = 1.34;
    final double WALKING_PENALTY = 2;
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        nodes = new HashMap<>();
    }

    public Graph(List<BusStop> busStops) {
        this.isDirected = true;
        this.nodes = new HashMap<>();
        for(BusStop busStop : busStops) {
            addNode(busStop);
        }
    }
    public void solveEdges(){
        for(Node currentNode: nodes.values()){
            for(Node targetNode : nodes.values()){
                if(!currentNode.equals(targetNode)){
                    double distance = HaversineDistance.distance(currentNode.getLatitude(), currentNode.getLongitude(), targetNode.getLatitude(), targetNode.getLongitude());
                    if(currentNode.getRouteName().equals(targetNode.getRouteName()) && distance <= 250) {
                        currentNode.addEdge(new Edge(calculateWeight(distance, FormOfTransport.LINEA), currentNode, targetNode, FormOfTransport.LINEA));
                    }
                    else if(!currentNode.getRouteName().equals(targetNode.getRouteName()) && distance <= 150){
                        currentNode.addEdge(new Edge(calculateWeight(distance, FormOfTransport.CAMINATA), currentNode, targetNode, FormOfTransport.CAMINATA));
                    }
                }
            }
        }
    }

    private double calculateWeight(double distance, FormOfTransport transport) {
        double res = 0;
        if(transport == FormOfTransport.LINEA) {
            res = distance / BUS_SPEED;
        } else if(transport == FormOfTransport.CAMINATA) {
            res = (distance / WALKING_SPEED) * WALKING_PENALTY;
        }
        return res;
    }

    public void addNode(BusStop stop) {
        nodes.putIfAbsent(stop, new Node(stop));
    }

    public void addEdge(Node fromNode,Node toNode, double weight, FormOfTransport type) {
        if (fromNode == null || toNode == null) return;
        fromNode.getEdges().add(new Edge(weight, fromNode, toNode,type));
        if (!isDirected) {
            toNode.getEdges().add(new Edge(weight, toNode, fromNode,type));
        }
    }

    public void printBfs(BusStop startingBus) {
        resetAllNodes();

        Queue<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(nodes.get(startingBus));

        while (!nodesToVisit.isEmpty()) {
            Node current = nodesToVisit.remove();
            if (!current.isVisited()) {
                current.setVisited();
                System.out.println(current.getRouteName());
                for (Edge edge : current.getEdges()) {
                    Node edgeNode = edge.getTargetNode();
                    if (!edgeNode.isVisited()) {
                        nodesToVisit.add(edgeNode);
                    }
                }
            }
        }
    }

    public void printDfs(BusStop startingBus) {
        resetAllNodes();
        printDfsRec(nodes.get(startingBus));
    }

    private void printDfsRec(Node node) {
        if (node.isVisited()) {
            return;
        }
        node.setVisited();
        System.out.println(node.getRouteName());

        for (Edge edge : node.getEdges()) {
            Node edgeNode = edge.getTargetNode();
            if (!edgeNode.isVisited()) {
                printDfsRec(edgeNode);
            }
        }
    }

    public void computePath(Node sourceNode) {
        sourceNode.setMinDistance(0);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceNode);

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (Edge edge : node.getEdges()) {
                Node v = edge.getTargetNode();
                double weight = edge.getWeight();
                double minDistance = node.getMinDistance() + weight;

                if (minDistance < v.getMinDistance()) {
                    priorityQueue.remove(node);
                    v.setPreviousNode(node);
                    v.setMinDistance(minDistance);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Node> getShortestPathTo(Node targetNode) {
        List<Node> path = new ArrayList<>();

        for (Node node = targetNode; node != null; node = node.getPreviousNode()) {
            path.add(node);
        }

        Collections.reverse(path);
        return path;
    }

    private void resetAllNodes() { nodes.values().forEach(Node::setNotVisited);}
}
