package avltree;

/**
 * @author Sandesh Mendan on 30/06/20
 * @project algorithms-and-datastructures
 */
public class AvlMain {
    public static void main(String[] args) {

        // Constructor
        AVLTree tree = new AVLTree();

        // Insert values in AVL Tree
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        System.out.println("Preorder traversal of "+
                "constructed tree is : ");  //9 1 0 -1 5 2 6 10 11
        tree.preOrder(tree.root);

        tree.root = tree.deleteNode(tree.root, 10);
        System.out.println("\nPreorder traversal after "+
                "deletion of 10 :");    //1 0 -1 9 5 2 6 11
        tree.preOrder(tree.root);
    }
}
