import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

public class Graph {
    private Map<String, List<String>> graph;

/*  @Override
    public String toString() { SOLO PARA TESTEAR LA CONSTRUCCION DEL GRAFO
        for(String auxFrom: graph.keySet()){
            for(String aux:graph.get(auxFrom)){
                System.out.println(auxFrom+"-->"+aux);
            }
        }
        return "ENDDDD";
    }*/

    public Graph() {
        this.graph = new HashMap<>();
    }
    public void addNode(String location){
        graph.putIfAbsent(location, new ArrayList<>());
    }
   public void addEdge(String from, String to){
        if(graph.get(from)==null||graph.get(to)==null)
            return;
        graph.get(from).add(to);
        graph.get(to).add(from);
    }
    public void BFS(String startpoint){
        System.out.println("NUEVA ITERACIÓN");
        Set<String> visited=new HashSet<>();
        visited.add(startpoint);
        System.out.println(startpoint);
        Set<String> current= new HashSet<>();
        current.add(startpoint);
        while(visited.size()< graph.size()){
            Set<String> next=new HashSet<>();
            for(String node : current){
                List<String> adyacent= graph.get(node);
                for(String adyacente : adyacent){
                    if(!visited.contains(adyacente)){
                        visited.add(adyacente);
                        System.out.println(adyacente);
                        next.add(adyacente);
                    }
                }
            }
            System.out.println("------------");//SEPARADOR DE NIVELES
            current=next;
        }
    }
/*    private List<String> getSons(String node){ SOLO SI SE USA LA CLASE EDGE, Devuelve los hijos de un nodo
        List<String> sons=new ArrayList<>();
        for(Edge edge : graph.get(node)){
            sons.add(edge.targetLabel);
        }
        return sons;
    }*/
    static class Edge{
        String targetLabel;

        public Edge(String targetLabel) {
            this.targetLabel = targetLabel;
        }
    }
}
