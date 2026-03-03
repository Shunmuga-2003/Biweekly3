package BinaryTrees;

import java.util.*;

class TreeNodes {
    int val;
    TreeNodes left, right;

    TreeNodes(int data) {
        this.val = data;
        left = right = null;
    }
}

public class BinaryTreeTopView {

    // Helper Pair class
    static class Pair {
        TreeNodes node;
        int hd;

        Pair(TreeNodes node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> topView(TreeNodes root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store the first node at every horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNodes curr = p.node;
            int hd = p.hd;

            // If HD is seen for the first time, store it
            if (!map.containsKey(hd)) {
                map.put(hd, curr.val);
            }

            if (curr.left != null) queue.offer(new Pair(curr.left, hd - 1));
            if (curr.right != null) queue.offer(new Pair(curr.right, hd + 1));
        }

        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        TreeNodes root = new TreeNodes(1);
        root.left = new TreeNodes(2);
        root.right = new TreeNodes(3);
        root.left.left = new TreeNodes(4);
        root.left.right = new TreeNodes(5);
        root.right.left = new TreeNodes(6);
        root.right.right = new TreeNodes(7);

        List<Integer> topViewList = topView(root);
        System.out.println("Top View: " + topViewList);
    }
}

