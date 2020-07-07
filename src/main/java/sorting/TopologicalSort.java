package sorting;

import graph.dfs.Dfs;
import node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Sandesh Mendan on 07/07/20
 * @project algorithms-and-datastructures
 */
public class TopologicalSort {
    public static void main(String[] args){
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        //create 8 nodes: V1-V8
        for(int i=1;i<9; i++)
            nodeList.add(new GraphNode("V"+i));

        //Constructor
        TopologicalSort graph = new TopologicalSort(nodeList);

        //add edges following graph in graph
        graph.addDirectedEdge(1,3);
        graph.addDirectedEdge(2,3);
        graph.addDirectedEdge(2,4);
        graph.addDirectedEdge(3,5);
        graph.addDirectedEdge(4,6);
        graph.addDirectedEdge(5,6);
        graph.addDirectedEdge(5,8);
        graph.addDirectedEdge(6,7);

        //from V1
        System.out.println("Topologically sorted elements are (starting node V1) : ");
        graph.topologicalSort();
    }

    ArrayList<GraphNode> nodes;

    public TopologicalSort(ArrayList<GraphNode> nodes){
        this.nodes = nodes;
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodes.get(i - 1);
        GraphNode second = nodes.get(j - 1);
        first.getNeighbors().add(second);
    }

    private void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodes)
            if(!node.isVisited())
                topologicalSortVisit(node, stack);
        while (!stack.isEmpty())
            System.out.print(stack.pop().getName() + " ");
    }

    private void topologicalSortVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.getNeighbors())
            if(!neighbor.isVisited())
                topologicalSortVisit(neighbor, stack);

        node.setVisited(true);
        stack.push(node);

    }
}
