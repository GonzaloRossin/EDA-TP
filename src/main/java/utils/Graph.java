package utils;
import java.util.*;

public class Graph {
    private final boolean isDirected;
    public Map<BusStop, Node> nodes;

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

    public void addNode(BusStop stop) {
        nodes.putIfAbsent(stop, new Node(stop));
    }

    public void addEdge(BusStop firstBus, BusStop secondBus, double weight) {
        Node node1 = nodes.get(firstBus);
        Node node2 = nodes.get(secondBus);
        if (node1 == null || node2 == null) return;
        node1.getEdges().add(new Edge(weight, node1, node2));
        if (!isDirected) {
            node2.getEdges().add(new Edge(weight, node2, node1));
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
                System.out.println(current.getBusLine());
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
        System.out.println(node.getBusLine());

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
