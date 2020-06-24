package stack;

public class StackByLinkedListMain {
    public static void main(String[] args) {
        System.out.println("Creating a stack");
        StackByLinkedList stack = new StackByLinkedList();

        System.out.println("Pushing ten values into stack");
        for (int i = 1; i <= 10; i++)
            stack.push(i * 10);
        System.out.println();

        System.out.println("Peeking value");
        System.out.println(stack.peek());
        System.out.println();

        System.out.println("Popping 11 values from stack");
        for (int i = 1; i <= 11; i++)
            System.out.println(stack.pop());
    }
}
