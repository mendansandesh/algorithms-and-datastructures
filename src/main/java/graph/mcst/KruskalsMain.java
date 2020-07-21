package graph.mcst;

import node.WeightedNode;

import java.util.ArrayList;

public class KruskalsMain {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        //create 10 nodes: V1-V5
        for(int i=1; i<=5; i++)
            nodeList.add(new WeightedNode("" + "V" + i));

        Kruskals graph = new Kruskals(nodeList);
        //Add A<-> B , weight 10
        graph.addWeightedUndirectedEdge(1,2,15);
        //Add A<-> C , weight 20
        graph.addWeightedUndirectedEdge(1,3,20);
        graph.addWeightedUndirectedEdge(2,3,13);
        graph.addWeightedUndirectedEdge(2,4,5);
        graph.addWeightedUndirectedEdge(3,4,10);
        graph.addWeightedUndirectedEdge(3,5,6);
        graph.addWeightedUndirectedEdge(4,5,8);


        System.out.println("Running Kruskal's Algo on the graph: ");
        graph.kruskal(); //Note: getting partially correct result
    }
}
