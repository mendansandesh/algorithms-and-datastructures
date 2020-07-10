package graph.bellmanford;

import node.WeightedNode;
import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 10/07/20
 * @project algorithms-and-datastructures
 */
public class BellmanFordSssp {
    ArrayList<WeightedNode> nodes;

    public BellmanFordSssp(ArrayList<WeightedNode> nodes){
        this.nodes = nodes;
        for(WeightedNode node: nodes)
            node.setDistance(Integer.MAX_VALUE/10);
    }

    public void addWeightedEdge(int i, int j, int weight) {
        WeightedNode fromNode = nodes.get(i - 1);
        WeightedNode toNode   = nodes.get(j - 1);
        fromNode.getNeighbors().add(toNode);
        fromNode.getWeightMap().put(toNode, weight);
    }

    public void bellmanFord(WeightedNode sourceNode) {
        System.out.println("Source: " + sourceNode.getName());
        sourceNode.setDistance(0);    //set source dist. to 0

        for (int i = 1; i < nodes.size(); i++) {  //repeat V-1 times
            for (WeightedNode node : nodes) {     //for each node
                for (WeightedNode neighbor : node.getNeighbors()) {   //keep updating its neighbors
                    int currentEdgeWeight = node.getWeightMap().get(neighbor);
                    if ((node.getDistance() + currentEdgeWeight) < neighbor.getDistance()) {
                        neighbor.setDistance(node.getDistance() + currentEdgeWeight);  //update neighbor
                        neighbor.setParent(node);
                    }
                }
            }
        }

        System.out.println("Checking for Negative Cycle ...");
        for (WeightedNode node : nodes) {
            for (WeightedNode neighbor : node.getNeighbors()) {
                int currentEdgeWeight = node.getWeightMap().get(neighbor);
                if ((node.getDistance() + currentEdgeWeight) < neighbor.getDistance()) { //if +ve edge: (node.getDistance() + currentEdgeWeight) >= neighbor.getDistance()
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex Name: " + neighbor.getName());
                    System.out.println("Old Distance: " + neighbor.getDistance());
                    System.out.println("New distance: " + currentEdgeWeight);
                    return;
                }
            }
        }

        System.out.println("Negative cycle not found !");
        for(WeightedNode eachNode : nodes){
            if (eachNode.getDistance() != Integer.MAX_VALUE / 10) {
                System.out.println("Destination Node "+ eachNode.getName() +", distance: "+ eachNode.getDistance()+", Path: ");
                printPath(eachNode);
            } else
                System.out.print("No path for node " + eachNode);
            System.out.println();
        }
    }

    private void printPath(WeightedNode node) {
        if(node.getParent() != null) {
            printPath(node.getParent());
            System.out.print(" -> " + node.getName());
        }else
            System.out.print(node.getName());
    }
}
