import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
