package interview.walmart;

import java.util.Stack;


/**
 * @author sandesh.mendan on 06/11/20
 * @project algorithms-and-datastructures
 */
// Problem: desgin a stack with getMin() at O(1); can take extra space
class StackConstantTime {
    //one stack approach but adding extra elements i.e, storing second min as well
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public StackConstantTime() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(val <= min){
            stack.push(min); //store second/old min
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop() == min)
            min = stack.pop(); //at this stage stack.pop() gives second min; so update to min
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    /*
    // Two stack approach
    Stack<Integer> primary = new Stack<>();
    Stack<Integer> secondary = new Stack<>();

    public void push(int val) {
        if(secondary.isEmpty() || val <= secondary.peek())
            secondary.push(val);
        primary.push(val);
    }

    public void pop() {
        if(primary.peek().equals(secondary.peek()))
            secondary.pop();
        primary.pop();
    }
    public int top() {
        return primary.peek();
    }

    public int getMin() {
        return secondary.peek();
    }*/

    /*
    // Single stack approach; confusing though;
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
    }*/
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