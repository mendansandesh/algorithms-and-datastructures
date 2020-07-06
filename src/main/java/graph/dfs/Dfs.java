package graph.dfs;

import node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Sandesh Mendan on 06/07/20
 * @project algorithms-and-datastructures
 */
public class Dfs {
    ArrayList<GraphNode> nodes = new ArrayList<>();

    public Dfs(ArrayList<GraphNode> nodes){
        this.nodes = nodes;
    }

    void addUndirectedEdge(int i, int j){
        GraphNode nodeA = nodes.get(i - 1);
        GraphNode nodeB = nodes.get(j - 1);
        nodeA.getNeighbors().add(nodeB);
        nodeB.getNeighbors().add(nodeA);
    }

    void dfs(){
        for(GraphNode node : nodes)
            if(!node.isVisited())
                dfsVisit(node);
    }

    void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode topOfStack = stack.pop();
            if(!topOfStack.isVisited()){
                System.out.println(topOfStack.getName() + " ");
                topOfStack.setVisited(true);
                for(GraphNode neighbor : topOfStack.getNeighbors())
                    if(!neighbor.isVisited())
                        stack.push(neighbor);
            }
        }
    }
}
