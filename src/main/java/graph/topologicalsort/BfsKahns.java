package graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsKahns {
    static int[] topologicalSort(int V, int[][] adj){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        // Build the adjacency list
        for(int[] edge : adj){
            int from = edge[1];
            int to   = edge[0];
            graph.get(from).add(to);
        }

        //indegree having count of all incoming edges of every node in the adjacency list
        int[] indegree = new int[V];
        for(int node = 0; node < V; node++){
            for(int adjNode : graph.get(node)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        //push all the nodes with indegree 0 => these nodes can possibly be the 1st node of the final order
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int[] result = new int[V];
        int i = 0;
        while (!queue.isEmpty()){
            //take the node out of queue; which can be added to result
            int node = queue.remove();
            result[i++] = node;
            //since this node could have outgoing edges to other nodes(neighbors); need to process those neighbors/adjacent nodes
            for(int neighbor : graph.get(node)){
                //keep decrement the indegree of adjacent node, everytime we traverse from node to its adjacent node
                indegree[neighbor]--;
                //have a check if at all that adjacent node indegree becomes 0, then we need to add it to the queue(as we did earlier)
                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        int[] order = topologicalSort(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}
