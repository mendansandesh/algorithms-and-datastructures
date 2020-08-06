package problems.hackerrank;

/**
 * @author sandesh.mendan on 23/07/20
 * @project algorithms-and-datastructures
 */
//Problem: https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttack {
    public static void main(String[] args){
        //create obstacles 2D matrix
        int boardSize = 5; //row index starts from 1 to N in direction bottom to top; i.e, first row's index is N
        int numOfObstacle = 3;
        int[][] obstacleMatrix = createObstacleMatrix(numOfObstacle);
        System.out.println(queensAttack(boardSize, numOfObstacle, 4, 3, obstacleMatrix));
    }

    private static int[][] createObstacleMatrix(int numOfObstacle) {
        //each row stores row and column position for each obstacle in the main chess board
        int[][] obstacleMatrix = new int[numOfObstacle][2]; //col 2 because row and col position of obstacle
        obstacleMatrix[0][0] = 5; obstacleMatrix[0][1] = 5;
        obstacleMatrix[1][0] = 4; obstacleMatrix[1][1] = 2;
        obstacleMatrix[2][0] = 2; obstacleMatrix[2][1] = 3;
        return obstacleMatrix;
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        //no obstacles
        int left  = c_q - 1;    //queen to left boundary
        int right = n - c_q;    //queen to right boundary
        int up    = n - r_q;    //queen to top boundary
        int down  = r_q - 1;    //queen to bottom boundary
        int upleft    = Math.min(up, left);     //queen to top left diagonal boundary
        int upright   = Math.min(up, right);    //queen to top right diagonal boundary
        int downleft  = Math.min(down, left);   //queen to bottom left diagonal boundary
        int downright = Math.min(down, right);  //queen to bottom right diagonal boundary

        //if obstacles
        for(int o = 0; o < k; o++){
            int row = obstacles[o][0];
            int col = obstacles[o][1];

            //left
            if(row == r_q && col < c_q) //obs is somewhere in queen's left
                if(c_q - col - 1 < left) //check and update left if obs is in between queen and left
                    left = c_q - col - 1;
            //right
            if(row == r_q && col > c_q)
                if(col - c_q - 1 < right)
                    right = col - c_q - 1;
            //up
            if(col == c_q && row > r_q)
                if(row - r_q - 1 < up)
                    up = row - r_q - 1;
            //down
            if(col == c_q && row < r_q)
                if(r_q - row - 1 < down)
                    down = r_q - row - 1;
            //upleft
            if(row > r_q && col < c_q)  //obs is somewhere in queen top left area
                if(row - r_q == c_q - col)  //obs is in queen's upleft(diagonal)
                    if(row - r_q - 1 < upleft)   //check and update upleft if obs is in between queen and upleft
                        upleft = row - r_q - 1;
            //upright
            if(row > r_q && col > c_q)
                if(row - r_q == col - c_q)
                    if(row - r_q - 1 < upright)
                        upright = row - r_q - 1;
            //downleft
            if(row < r_q && col < c_q)
                if(r_q - row == c_q - col)
                    if(r_q - row - 1 < downleft)
                        downleft = r_q - row - 1;
            //downright
            if(row < r_q && col > c_q)
                if(r_q - row == col - c_q)
                    if(r_q - row - 1 < downright)
                        downright = r_q - row - 1;

        }
        return left + right + up + down + upleft + upright + downleft + downright;
    }

}
