package interview.salesforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Problem: https://leetcode.com/problems/open-the-lock/
// Time: O(V + E)
// Space: O(N)
public class OpenTheLock {
    public static void main(String[] a){
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    private static int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int minSteps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String qFront = queue.remove();
                if(deadendSet.contains(qFront))
                    continue;
                if(qFront.equals(target))
                    return minSteps;
                for(int j = 0; j < 4; j++){
                    String clockwise = rotateClockwise(qFront, j);
                    if(!visited.contains(clockwise)){
                        visited.add(clockwise);
                        queue.add(clockwise);
                    }
                    String anticlockwise = rotateAntiClockwise(qFront, j);
                    if(!visited.contains(anticlockwise)){
                        visited.add(anticlockwise);
                        queue.add(anticlockwise);
                    }
                }
            }
            minSteps++;
        }
        return minSteps;
    }

    private static String rotateClockwise(String string, int rotationIndex) {
        char[] chars = string.toCharArray();
        if(chars[rotationIndex] == '9')
            chars[rotationIndex] = '0';
        else
            chars[rotationIndex] += 1;
        return new String(chars);
    }
    private static String rotateAntiClockwise(String string, int rotationIndex) {
        char[] chars = string.toCharArray();
        if(chars[rotationIndex] == '0')
            chars[rotationIndex] = '9';
        else
            chars[rotationIndex] -= 1;
        return new String(chars);
    }

}