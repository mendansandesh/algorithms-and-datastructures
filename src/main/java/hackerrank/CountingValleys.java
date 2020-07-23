package hackerrank;

import java.util.Stack;

/**
 * @author sandesh.mendan on 23/07/20
 * @project algorithms-and-datastructures
 */
//Problem: https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {
    public static void main(String[] args){
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }
    static int countingValleys(int n, String s) {
        char[] inpChar = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int c = 0;
        int a = 0;
        for (int i = 0; i < n; i++){
            a = (inpChar[i] == 'D') ? -1 : 1;
            if (stack.empty()) {
                stack.push(a);
                prev = stack.peek();
                continue;
            }
            if(a == prev)
                stack.push(a);
            else {
                if(stack.size() == 1 && stack.peek() == -1)
                    c++;
                stack.pop();
            }
            prev = (stack.empty()) ? 0 : stack.peek();
        }
        return c;
    }
}
