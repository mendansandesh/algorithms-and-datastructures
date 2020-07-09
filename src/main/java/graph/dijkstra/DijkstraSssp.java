package graph.dijkstra;

import node.GraphNode;
import node.WeightedNode;

import java.util.*;

/**
 * @author Sandesh Mendan on 08/07/20
 * @project algorithms-and-datastructures
 */
public class DijkstraSssp {
    ArrayList<WeightedNode> nodes;

    public DijkstraSssp(ArrayList<WeightedNode> nodes){
        this.nodes = nodes;
    }

    public void addWeightedEdge(int i, int j, int weight) {
        WeightedNode fromNode = nodes.get(i - 1);
        WeightedNode toNode   = nodes.get(j - 1);
        fromNode.getNeighbors().add(toNode);
        fromNode.getWeightMap().put(toNode, weight);
    }

    private void printPath(WeightedNode node) {
        if(node.getParent() != null) {
            printPath(node.getParent());
            System.out.print(" -> " + node.getName());
        }else
            System.out.print(node.getName());
    }

    void dijkstra(WeightedNode node) {
        System.out.println("Source: " + node.getName());
        node.setDistance(0);
        Queue<WeightedNode> minHeap = new PriorityQueue<>(distanceComparator);
        minHeap.addAll(nodes);
        while (!minHeap.isEmpty()){
            WeightedNode topNode = minHeap.remove();
            for(WeightedNode neighbor : topNode.getNeighbors()){
                int currentEdge = topNode.getWeightMap().get(neighbor);
                if((topNode.getDistance() + currentEdge) < neighbor.getDistance()) {
                    neighbor.setDistance(topNode.getDistance() + currentEdge);
                    neighbor.setParent(topNode);
                    minHeap.remove(neighbor);
                    minHeap.add(neighbor);
                }
            }
        }
        for(WeightedNode eachNode : nodes){
            System.out.print("Destination Node "+ eachNode.getName() +", distance: "+ eachNode.getDistance()+", Path: ");
            printPath(eachNode);
            System.out.println();
        }
    }

    public static Comparator<WeightedNode> distanceComparator = new Comparator<WeightedNode>(){

        @Override
        public int compare(WeightedNode c1, WeightedNode c2) {
            return (int) (c1.getDistance() - c2.getDistance());
        }
    };
}
