package problems.leetcode;

import node.BinaryNode;
// Problem: https://leetcode.com/problems/same-tree/
// TimeComplexity:
// SpaceComplexity:
public class TreeIdentical {
    public static void main(String[] args) {

        BinaryNode tree1 = new BinaryNode(1);
        tree1.left = new BinaryNode(2);
        tree1.right = new BinaryNode(3);

        BinaryNode tree2 = new BinaryNode(1);
        tree2.left = new BinaryNode(3);
        tree2.right = new BinaryNode(2);

        System.out.println(isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(BinaryNode p, BinaryNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return ((p.key == q.key) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)));
    }

    /*class Pair{
        TreeNode node1;
        TreeNode node2;
        Pair(TreeNode n1,TreeNode n2){
            this.node1 = n1;
            this.node2 = n2;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null) return false;
        if(q == null) return false;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(p,q));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                Pair temp = queue.poll();
                if(temp.node1 == null && temp.node2 == null) continue;
                if(temp.node1 == null || temp.node2 == null) return false;
                if(temp.node1.val != temp.node2.val) return false;

                queue.offer(new Pair(temp.node1.left,temp.node2.left));
                queue.offer(new Pair(temp.node1.right,temp.node2.right));
            }
        }
        return queue.isEmpty();
    }*/
}
