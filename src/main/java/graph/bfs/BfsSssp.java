package graph.bfs;

import node.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Sandesh Mendan on 08/07/20
 * @project algorithms-and-datastructures
 */
public class BfsSssp {
    ArrayList<GraphNode> nodes = new ArrayList<>();

    public BfsSssp(ArrayList<GraphNode> nodes){
        this.nodes = nodes;
    }

    void addUndirectedEdge(int i, int j){
        GraphNode nodeA = nodes.get(i - 1);
        GraphNode nodeB = nodes.get(j - 1);
        nodeA.getNeighbors().add(nodeB);
        nodeB.getNeighbors().add(nodeA);
    }

    void bfsForSSSP(GraphNode node){
        System.out.println("Starting node: " + node.getName());
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode headOfQueue = queue.remove();
            if(!headOfQueue.isVisited()){
                System.out.println("path to node "+ headOfQueue.getName()+": ");
                headOfQueue.setVisited(true);
                printPath(headOfQueue);
                System.out.println();
                for(GraphNode neighbor : headOfQueue.getNeighbors()){
                    if(!neighbor.isVisited()){
                        neighbor.setParent(headOfQueue);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    private void printPath(GraphNode node) {
        if(node.getParent() != null)
            printPath(node.getParent());
        System.out.print(node.getName() + " ");
    }
}
