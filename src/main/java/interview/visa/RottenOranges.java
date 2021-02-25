package interview.visa;

import java.util.HashSet;
import java.util.Set;

//Problem: https://leetcode.com/problems/rotting-oranges/
// TimeComplexity:  O(N) : size of the grid
// SpaceComplexity: O(N) : using fresh and rotten sets
public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{ 2,1,1 }, { 1,1,0 }, { 0,1,1 }};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1)
                    fresh.add("" + i + j);
                if(grid[i][j] == 2)
                    rotten.add("" + i + j);
            }
        }

        int minutes = 0;
        int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        //BFS
        while(fresh.size() > 0){
            Set<String> infected = new HashSet<>(); //to store all oranges which are converted from fresh to rotten
            for(String s : rotten){
                int currRottenI = s.charAt(0) - '0'; //ascii
                int currRottenJ = s.charAt(1) - '0';
                for(int[] direction : directions){
                    int nextRottenI = currRottenI + direction[0];
                    int nextRottenJ = currRottenJ + direction[1];
                    if(fresh.contains("" + nextRottenI + nextRottenJ)){
                        fresh.remove("" + nextRottenI + nextRottenJ);
                        infected.add("" + nextRottenI + nextRottenJ);
                    }
                }
            }

            if(infected.size() == 0)
                return -1;

            rotten = infected;
            minutes++;
        }

        return minutes;
    }
}
