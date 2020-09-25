import java.util.*;

public class Graph {

    private final boolean isDirected;
    Map<String, Node> nodes;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        nodes = new HashMap<>();
    }

    void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void removeNode(String label) {
        // TO do
    }

    void addEdge(String label1, String label2) {
        Node node1 = nodes.get(label1);
        Node node2 = nodes.get(label2);
        if (node1 == null || node2 == null) {
            return;
        }
        node1.edges.add(node2);
        if (!isDirected) {
            node2.edges.add(node1);
        }
    }

    void removeEdge(String label1, String label2) {
        //TO do
    }

    void printBfs(String startingLabel) {
        unmarkAllNodes();

        Queue<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(nodes.get(startingLabel));

        while (!nodesToVisit.isEmpty()) {
            Node current = nodesToVisit.remove();
            if (!current.marked) {
                current.mark();
                System.out.println(current.label);
                for (Node edgeNode : current.edges) {
                    if (!edgeNode.marked) {
                        nodesToVisit.add(edgeNode);
                    }
                }
            }
        }
    }

    void printDfs(String startingLabel) {
        unmarkAllNodes();
        printDfsRec(nodes.get(startingLabel));
    }

    private void printDfsRec(Node node) {
        if (node.marked) {
            return;
        }
        node.mark();
        System.out.println(node.label);

        for (Node edgeNode : node.edges) {
            if (!edgeNode.marked) {
                printDfsRec(edgeNode);
            }
        }
    }

    private void unmarkAllNodes() {
        nodes.values().forEach(Node::unmark);
    }

    public int inDegree(String label) {
        return 0;
    }

    public int outDegree(String label) {
        return 0;
    }

    public int connectedComponents() {
        return 0;
    }

    List<List<String>> getAllPaths(String from, String to) {
        return new ArrayList<>();
    }

    class Node {
        String label;
        Set<Node> edges;
        boolean marked;

        public Node(String label) {
            this.label = label;
            edges = new HashSet<>();
        }

        void mark() {
            marked = true;
        }

        void unmark() {
            marked = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(label, node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "label='" + label + '\'' +
                    '}';
        }
    }

}
