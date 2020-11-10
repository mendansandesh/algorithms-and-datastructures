package interview.walmart;

import java.util.Stack;


/**
 * @author sandesh.mendan on 06/11/20
 * @project algorithms-and-datastructures
 */
// Problem: desgin a stack with getMin() at O(1); can take extra space
class StackConstantTime {
    int min; //this stores the min at any point in time
    Stack<Integer> stack; //stores actual elems as well as intermediate computed values

    StackConstantTime(){
        stack = new Stack<>();
    }
    public void push(int elem){
        if(stack.isEmpty()) {
            min = elem;
            stack.push(elem);
        }
        if(elem >= min)
            stack.push(elem);
        else {
            stack.push( 2 * elem - min );
            min = elem;
        }
    }
    public void pop(){
        if(stack.isEmpty())
            System.out.println("Stack empty!");
        if(stack.peek() >= min)
            stack.pop();
        else {
            min = 2 * min - stack.peek();
            stack.pop();
        }
    }
    public int getMin(){
        return min;
    }
}

class Main{
    public static void main(String[] args){
        StackConstantTime s = new StackConstantTime();
        s.push(8);
        s.push(10);
        System.out.println(s.getMin());
        s.push(6);
        System.out.println(s.getMin());
        s.push(3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.push(7);
        System.out.println(s.getMin());
        System.out.println();
    }
}