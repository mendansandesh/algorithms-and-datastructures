package graph.mcst;

import node.WeightedNode;

import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 16/07/20
 * @project algorithms-and-datastructures
 */
public class DisjointSetMain {
    public static void main(String[] args) {

        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            nodeList.add(new WeightedNode("" + "V" + i));

        DisjointSet.driver(nodeList);

    }
}
