import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> graph;

    @Override
    public String toString() {
        for(String auxFrom: graph.keySet()){
            for(Edge aux:graph.get(auxFrom)){
                System.out.println(auxFrom+aux.toString());
            }
        }
        return "ENDDDD";
    }

    public Graph() {
        this.graph = new HashMap<>();
    }
    public void addNode(String location){
        graph.putIfAbsent(location, new ArrayList<>());
    }
    public void addEdge(String from, String to,double weight){
        if(graph.get(from)==null||graph.get(to)==null)
            return;
        graph.get(from).add(new Edge(to,weight));
        graph.get(to).add(new Edge(from,weight));
    }
    static class Edge{
        String targetLabel;
        double weight;

        @Override
        public String toString() {
            return "--->("+weight+")"+targetLabel;
        }

        public Edge(String targetLabel, double weight) {
            this.targetLabel = targetLabel;
            this.weight = weight;

        }
    }
}
