package graph.bellmanford;

import node.WeightedNode;
import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 10/07/20
 * @project algorithms-and-datastructures
 */
public class BellmanFordSsspMain {
    public static void main(String[] args) {

        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        //create 5 nodes
        for(int i=1;i<6; i++) {
            nodeList.add(new WeightedNode("V"+i));
        }

        //Constructor
        BellmanFordSssp graph = new BellmanFordSssp(nodeList);

        graph.addWeightedEdge(1,3,6); //Add V1 -> V3 , weight 6
        graph.addWeightedEdge(1,4,6); //Add V1 -> V4 , weight 6
        //graph.addWeightedEdge(1,4, -6); //negative edge check
        graph.addWeightedEdge(2,1,3); //Add V2 -> V1 , weight 3
        graph.addWeightedEdge(3,4,2); //Add V3 -> V4 , weight 2
        graph.addWeightedEdge(4,3,1); //Add V4 -> V3 , weight 1
        graph.addWeightedEdge(4,2,1); //Add V4 -> V2 , weight 1
        graph.addWeightedEdge(5,2,4); //Add V5 -> V2 , weight 4
        graph.addWeightedEdge(5,4,2); //Add V5 -> V4 , weight 2

        System.out.println("Printing BellmanFord SSSP for: ");
        graph.bellmanFord(nodeList.get(4));

    }
}
