package graph.floydwarshall;

import node.WeightedNode;

import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 10/07/20
 * @project algorithms-and-datastructures
 */
public class FloydWarshallMain {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        //Create 4 Vertices: A,B,C,D
        for (int i = 1; i < 5; i++)
            nodeList.add(new WeightedNode("V" + i));

        FloydWarshall graph = new FloydWarshall(nodeList);

        graph.addWeightedEdge(1, 2, 5);// Add A-> D , weight 1
        graph.addWeightedEdge(1, 4, 10);// Add A-> B , weight 8
        graph.addWeightedEdge(2, 3, 3);// Add B-> C , weight 1
        graph.addWeightedEdge(3, 4, 1);// Add C-> A , weight 4

        graph.floydWarshall();
    }
}
