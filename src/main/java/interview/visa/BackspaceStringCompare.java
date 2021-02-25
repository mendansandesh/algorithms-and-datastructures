package interview.visa;

import java.util.Stack;

//Problem: https://leetcode.com/problems/backspace-string-compare/
// TimeComplexity:  O(N) : O(S + T + S or T) // S or T for .equals()
// SpaceComplexity: O(N)
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompareNew("ab#c", "ad#c"));
    }

    public static boolean backspaceCompareNew(String S, String T) {
        Stack<Character> stackS = getStringAfterBackspacingNew(S);
        Stack<Character> stackT = getStringAfterBackspacingNew(T);

        while (!stackS.isEmpty()){
            char curr = stackS.pop();
            if(stackT.isEmpty() || stackT.pop() != curr)
                return false;
        }

        return stackS.isEmpty() && stackT.isEmpty(); //need not check for stackS.isEmpty() as its taken care in while condition
    }

    private static Stack<Character> getStringAfterBackspacingNew(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != '#')
                stack.push(c);
            else if(!stack.isEmpty())
                stack.pop();
        }
        return stack;
    }
    public static boolean backspaceCompare(String S, String T) {
        String afterBackspaceS = getStringAfterBackspacing(S);
        String afterBackspaceT = getStringAfterBackspacing(T);
        return afterBackspaceS.equals(afterBackspaceT);
    }

    private static String getStringAfterBackspacing(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != '#')
                sb.append(chars[i]);
            else
                sb.setLength(Math.max(sb.length() - 1, 0));
        }
        return sb.toString();
    }
}
