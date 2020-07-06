package node;

import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 06/07/20
 * @project algorithms-and-datastructures
 */
public class GraphNode {
    String name;
    int index;
    ArrayList<GraphNode> neighbors = new ArrayList<>();
    boolean isVisited = false;
    GraphNode parent;

    public GraphNode(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }
}
