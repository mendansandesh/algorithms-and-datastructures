package interview.inmobi;

import java.util.*;

/**
 * @author sandesh.mendan on 30/11/20
 * @project algorithms-and-datastructures
 */
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
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int minSteps = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String queueFront = queue.poll();
                if(deadendsSet.contains(queueFront))
                    continue;
                if(target.equals(queueFront))
                    return minSteps;
                for(int j = 0; j < 4; j++){ //4 bits; each can for 2 chars; total 8 string
                    String forward = clockwise(queueFront, j);
                    if(!visited.contains(forward)){
                        queue.offer(forward);
                        visited.add(forward);
                    }
                    String backward = anticlockwise(queueFront, j);
                    if(!visited.contains(backward)){
                        queue.offer(backward);
                        visited.add(backward);
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private static String clockwise(String str, int rotationIndex){
        char[] chars = str.toCharArray();
        if(chars[rotationIndex] == '9')
            chars[rotationIndex] = '0';
        else
            chars[rotationIndex] += 1;
        return new String(chars);
    }

    private static String anticlockwise(String str, int rotationIndex){
        char[] chars = str.toCharArray();
        if(chars[rotationIndex] == '0')
            chars[rotationIndex] = '9';
        else
            chars[rotationIndex] -= 1;
        return new String(chars);
    }
}
