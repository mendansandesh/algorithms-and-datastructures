package hackerrank;

import java.util.Stack;
/**
 * @author Sandesh Mendan on 23/07/20
 * @project algorithms-and-datastructures
 */

//Problem: https://www.hackerrank.com/challenges/balanced-brackets/problem
public class BalancedParanthesis {
    public static void main(String[] args){
        System.out.println(isBalanced("{[(])}"));
    }

    static String isBalanced(String s) {
        Stack<Character> stk = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(' )
                stk.push(ch);
            else if(ch == ']' || ch == '}' || ch == ')'){
                if(stk.isEmpty())
                    return "NO";
                switch(ch){
                    case ']':
                        if(stk.pop() != '[')
                            return "NO";
                        break;
                    case '}':
                        if(stk.pop() != '{')
                            return "NO";
                        break;
                    case ')':
                        if(stk.pop() != '(')
                            return "NO";
                        break;
                    default:
                        break;
                }
            }
        }
        if(stk.isEmpty())
            return "YES";
        return "NO";
    }
}
