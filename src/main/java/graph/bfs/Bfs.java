package graph.bfs;

import node.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Sandesh Mendan on 06/07/20
 * @project algorithms-and-datastructures
 */
public class Bfs {
    ArrayList<GraphNode> nodes = new ArrayList<>();

    public Bfs(ArrayList<GraphNode> nodes){
        this.nodes = nodes;
    }

    void addUndirectedEdge(int i, int j){
        GraphNode nodeA = nodes.get(i - 1);
        GraphNode nodeB = nodes.get(j - 1);
        nodeA.getNeighbors().add(nodeB);
        nodeB.getNeighbors().add(nodeA);
    }

    void bfs(){
        for(GraphNode node : nodes)
            if(!node.isVisited())
                bfsVisit(node);
    }

    private void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode headOfQueue = queue.remove();
            if(!headOfQueue.isVisited()) {
                System.out.println(headOfQueue.getName() + " ");
                headOfQueue.setVisited(true);
                for (GraphNode neighbor : headOfQueue.getNeighbors())
                    if (!neighbor.isVisited())
                        queue.add(neighbor);
            }
        }
    }
}
