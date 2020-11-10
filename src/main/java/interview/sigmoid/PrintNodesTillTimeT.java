package interview.sigmoid;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author sandesh.mendan on 27/10/20
 * @project algorithms-and-datastructures
 */
//  Print all the nodes which will be having message m1 at time = t
//  At T=0 , we are starting from node D,
//  T = 0 => D
//  T = 1 => D,F,G,C
//  T=3 => D,F,G,C,E,G,A,B
//  D
// but below assumed starting node as 1 and print all nodes at time T
public class PrintNodesTillTimeT {

    public static ArrayList<Graph> nodes = new ArrayList<>();

    public PrintNodesTillTimeT(ArrayList<Graph> nodes){
        this.nodes = nodes;
    }

    public static void main(String[] args){
        ArrayList<Graph> nodeList = new ArrayList<>();

        for(int i=1;i<7; i++)
            nodeList.add(new Graph(i));

        PrintNodesTillTimeT graph = new PrintNodesTillTimeT(nodeList);

        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(2,5);
        graph.addUndirectedEdge(3,6);

        printNodesAtTimeT(nodes.get(0), 3); //1 2 4 3 5
    }

    public void addUndirectedEdge(int i, int j){
        Graph nodeA = nodes.get(i - 1);
        Graph nodeB = nodes.get(j - 1);
        nodeA.getNeighbors().add(nodeB);
        nodeB.getNeighbors().add(nodeA);
    }

    private static void printNodesAtTimeT(Graph startNode, int time) {
        LinkedList<Graph> queue = new LinkedList<>();
        queue.add(startNode);
        queue.add(null);

        while (!queue.isEmpty() && time > 0){
            Graph headOfQueue = queue.remove();
            if(headOfQueue == null){
                time--;
                queue.add(null);
            }
            if (headOfQueue != null && !headOfQueue.isVisited()) {
                System.out.print(headOfQueue.getName() + " ");
                headOfQueue.setVisited(true);
                for (Graph neighbor : headOfQueue.getNeighbors()) {
                    if (!neighbor.isVisited())
                        queue.add(neighbor);
                }
            }
        }
    }
}

class Graph{
    int name;
    ArrayList<Graph> neighbors = new ArrayList<>();
    boolean isVisited = false;

    public Graph(int name){
        this.name = name;
    }
    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public ArrayList<Graph> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Graph> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}

