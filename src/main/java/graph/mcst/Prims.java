package graph.mcst;

import node.WeightedNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prims {
    ArrayList<WeightedNode> nodes = new ArrayList<>();
    int cost = 0;
    public Prims(ArrayList<WeightedNode> nodes){
        this.nodes = nodes;
    }

    public void addWeightedUndirectedEdge(int i, int j, int d) {
        WeightedNode first = nodes.get(i - 1);
        WeightedNode second = nodes.get(j - 1);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
        first.getWeightMap().put(second,d);
        second.getWeightMap().put(first, d);
    }

    // TODO: totally WRONG algorithm; need to solve using Disjoint set technique
    public void prims(WeightedNode node){
        Queue<WeightedNode> queue = new PriorityQueue<>(distanceComparator);
        node.setDistance(0);
        queue.addAll(nodes);
        while (!queue.isEmpty()){
           WeightedNode topNode = queue.remove();
            for (WeightedNode neighbor : topNode.getNeighbors()) {
                if (queue.contains(neighbor)) { // if neighbor is not processed
                    int currentDistance = topNode.getWeightMap().get(neighbor);
                    if ((topNode.getDistance() + currentDistance) < neighbor.getDistance()) {
                        neighbor.setDistance(topNode.getDistance() + currentDistance);
                        neighbor.setParent(topNode);
                        queue.remove(neighbor); //refresh priority queue
                        queue.add(neighbor);
                    }
                }
            }
        }

        for(WeightedNode eachNode : nodes){
            System.out.print("Destination Node "+ eachNode.getName() +", distance: "+ eachNode.getDistance()+", Path: ");
            cost += eachNode.getDistance();
            printPath(eachNode);
            System.out.println();
            /*System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: " + nodeToCheck.getParent());
            cost = cost + nodeToCheck.getDistance();*/
        }

        System.out.println("\nMinimum cost of spanning tree is: " + cost);
    }

    public static Comparator<WeightedNode> distanceComparator = new Comparator<WeightedNode>(){

        @Override
        public int compare(WeightedNode c1, WeightedNode c2) {
            return (int) (c1.getDistance() - c2.getDistance());
        }
    };

    private void printPath(WeightedNode node) {
        if(node.getParent() != null) {
            printPath(node.getParent());
            System.out.print(" -> " + node.getName());
        }else
            System.out.print(node.getName());
    }
}
