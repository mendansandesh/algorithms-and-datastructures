package graph.disjointset;

import node.WeightedNode;

import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 16/07/20
 * @project algorithms-and-datastructures
 */
public class DisjointSet {
    private ArrayList<WeightedNode> nodes = new ArrayList<>();

    public static void driver(ArrayList<WeightedNode> nodeList){
        makeSet(nodeList); //Create Disjoint Sets for each node in this list.
        for(int i= 0; i < nodeList.size()-1; i++) {
            WeightedNode firstNode = nodeList.get(i);
            WeightedNode secondNode = nodeList.get(i+1);
            System.out.println("Checking if node "+firstNode.getName() + " and " + secondNode.getName() + " belongs to different set, if yes, will Union them...");
            System.out.println("\nFirst Set name is: " + firstNode.getName());
            firstNode.getSet().printAllNodesOfThisSet();
            System.out.println("\nSecond Set name is: " + secondNode.getName());
            secondNode.getSet().printAllNodesOfThisSet();
            if(!findSet(firstNode).equals(findSet(secondNode))) {
                System.out.println("\nMaking union " + firstNode.getName() + " and " + secondNode.getName());
                DisjointSet unionedSet = union(firstNode, secondNode);
                unionedSet.printAllNodesOfThisSet();
            }
            System.out.println("\n**************************************\n");
        }
    }

    private static DisjointSet union(WeightedNode firstNode, WeightedNode secondNode) {
        if(firstNode.getSet().equals(secondNode.getSet()))
            return null;
        else {
            DisjointSet firstSet = firstNode.getSet();
            DisjointSet secondSet = secondNode.getSet();

            //try to make least transfer while performing union; by making set with more nodes as destination set
            if(firstSet.getNodes().size() > secondSet.getNodes().size()){
                firstSet.getNodes().addAll(secondSet.getNodes());
                return firstSet;
            }else {
                secondSet.getNodes().addAll(firstSet.getNodes());
                return secondSet;
            }
        }
    }

    private static DisjointSet findSet(WeightedNode node) {
        return node.getSet();
    }

    private void printAllNodesOfThisSet() {
        System.out.println("Printing all nodes of the set: ");
        for(WeightedNode node: nodes)
            System.out.print(node.getName() + "  ");
        System.out.println();
    }

    private static void makeSet(ArrayList<WeightedNode> nodesList) {
        for (WeightedNode node : nodesList){
            DisjointSet set = new DisjointSet();
            set.getNodes().add(node);
            node.setSet(set);   //Storing the reference of this Disjoint set in Node class
        }
    }

    public ArrayList<WeightedNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<WeightedNode> nodes) {
        this.nodes = nodes;
    }
}
