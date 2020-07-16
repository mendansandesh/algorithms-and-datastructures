package node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sandesh Mendan on 08/07/20
 * @project algorithms-and-datastructures
 */
public class WeightedNode {
    String name;
    ArrayList<WeightedNode> neighbors = new ArrayList<>();
    WeightedNode parent;
    int distance;
    HashMap<WeightedNode, Integer> weightMap = new HashMap<>();

    public WeightedNode(String name) {
        this.name = name;
        distance = 99999;   //infinity
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WeightedNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<WeightedNode> neighbors) {
        this.neighbors = neighbors;
    }

    public WeightedNode getParent() {
        return parent;
    }

    public void setParent(WeightedNode parent) {
        this.parent = parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public HashMap<WeightedNode, Integer> getWeightMap() {
        return weightMap;
    }

    public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
        this.weightMap = weightMap;
    }
}
