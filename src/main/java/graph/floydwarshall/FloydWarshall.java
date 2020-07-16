package graph.floydwarshall;

import node.WeightedNode;
import java.util.ArrayList;

/**
 * @author Sandesh Mendan on 10/07/20
 * @project algorithms-and-datastructures
 */
public class FloydWarshall {
    ArrayList<WeightedNode> nodes;

    public FloydWarshall(ArrayList<WeightedNode> nodes){
        this.nodes = nodes;
    }

    public void addWeightedEdge(int i, int j, int weight) {
        WeightedNode fromNode = nodes.get(i - 1);
        WeightedNode toNode   = nodes.get(j - 1);
        fromNode.getNeighbors().add(toNode);
        fromNode.getWeightMap().put(toNode, weight);
    }

    public void floydWarshall() {
        int size = nodes.size();
        //create adjacency matrix
        int[][] adjMat = createAdjacencyMatrix(size);

        System.out.println("\nAdjacency matrix for given inputs: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(adjMat[i][j] + " ");
            System.out.println();
        }

        //algorithm
        for(int k = 0; k < size; k++)
            for(int i = 0; i < size; i++)
                for(int j = 0; j < size; j++)
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]);

        //print result
        System.out.println("\nPrinting Floyd-Warshall from each vertex as source to other vertices:");
        for (int i = 0; i < adjMat.length; i++) {
            System.out.print("Printing distance list for node " + nodes.get(i).getName() + ": ");
            for (int j = 0; j < adjMat.length; j++)
                System.out.print(adjMat[i][j] + ", ");
            System.out.println();
        }
    }

    private int[][] createAdjacencyMatrix(int size) {
        int[][] adjMat = new int[size][size];
        for(int i = 0; i < size; i++){
            WeightedNode node = nodes.get(i);
            for(int j = 0; j < size; j++){
                if(i == j)
                    adjMat[i][j] = 0; //all diagonal elements always infinity
                else {
                    WeightedNode neighbor = nodes.get(j);
                    adjMat[i][j] = node.getWeightMap().getOrDefault(neighbor, 99999); // if edge present then set corresponding weight; if no edge then 0
                }
            }
        }
        return adjMat;
    }
}
