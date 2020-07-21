package graph.mcst;

import graph.util.UndirectedEdge;
import node.WeightedNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskals {
    ArrayList<WeightedNode> nodes = new ArrayList<>();
    ArrayList<UndirectedEdge> edges = new ArrayList<>();

    public Kruskals(ArrayList<WeightedNode> nodes){
        this.nodes = nodes;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight){
        WeightedNode first  = nodes.get(firstIndex - 1);
        WeightedNode second = nodes.get(secondIndex - 1);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
        first.getWeightMap().put(second, weight);
        second.getWeightMap().put(first, weight);
        UndirectedEdge edge = new UndirectedEdge(first, second, weight);
        edges.add(edge);
    }

    public void kruskal() {
        DisjointSet.makeSet(nodes);

        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge first, UndirectedEdge second) {
                return first.getWeight() - second.getWeight();
            }
        };

        //sort all edges in ascending order
        Collections.sort(edges, comparator);

        int cost = 0;
        for(UndirectedEdge edge : edges){
            if(!DisjointSet.findSet(edge.getFirst()).equals(DisjointSet.findSet(edge.getSecond()))){
            //if(!edge.getFirst().getSet().getNodes().contains()){
                DisjointSet.union(edge.getFirst(), edge.getSecond());
                //TODO: in very first processed edge(leftNode/firstParameterNode), the reference gets changed after
                // multiple iterations; rest are remains same;
                cost += edge.getWeight();
                System.out.println("Considered edge weight: " + edge.getWeight());
            }
        }
        System.out.println("\nMinimum cost of spanning tree is: " + cost);
    }
}
