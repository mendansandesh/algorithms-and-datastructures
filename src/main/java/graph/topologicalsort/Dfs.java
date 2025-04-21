package graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Dfs {
    static int[] topologicalSort(int V, int[][] adj) {
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

        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(visited, graph, stack, i);
            }
        }

        // pop stack to get one of the valid ordering as per topological sort
        int i = 0;
        int[] result = new int[V];
        while(!stack.isEmpty()){
            result[i++] = stack.pop();
        }

        return result;
    }

    static void dfs(int[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack, int node){
        //mark current node as visited
        visited[node] = 1;

        //look for adjacent nodes or neighbor if any and recursively call dfs on them if unvisited
        for(int neighbor : graph.get(node)){
            if(visited[neighbor] == 0){
                dfs(visited, graph, stack, neighbor);
            }
        }

        //once there is no directed edges/neighbor left to traverse, store them in a stack
        //this helps us to construct a valid order
        stack.push(node);
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
