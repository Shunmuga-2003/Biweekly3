package BinaryTrees;

import java.util.*;

class TreeNodeL {
    int val;
    TreeNodeL left, right;
    TreeNodeL(int x) {
        val = x;
    }
}

public class LeftViewBT {

    public static List<Integer> leftView(TreeNodeL root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNodeL> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNodeL curr = q.poll();

                // first node of this level
                if (i == 0) {
                    result.add(curr.val);
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
             \   \
              5   4
             /
            7
        */
        TreeNodeL root = new TreeNodeL(1);
        root.left = new TreeNodeL(2);
        root.right = new TreeNodeL(3);
        root.left.right = new TreeNodeL(5);
        root.right.right = new TreeNodeL(4);
        root.left.right.left = new TreeNodeL(7);

        List<Integer> view = leftView(root);
        System.out.println("Left View: " + view);
    }
}
