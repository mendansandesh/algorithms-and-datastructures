package interview.salesforce;

import java.util.ListIterator;
import java.util.Stack;

public class SortStackRecursion {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println(
                "Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(
                " \n\nStack elements after sorting:");
        printStack(s);
    }

    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int elem) {
        if(stack.isEmpty() || elem > stack.peek())
            stack.push(elem);
        else {
            int temp = stack.pop();
            sortedInsert(stack, elem);
            stack.push(temp);
        }
    }

    static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }
}
