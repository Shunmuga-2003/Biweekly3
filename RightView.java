package BinaryTrees;
    import java.util.*;

    class TreeNodeR {
        int val;
        TreeNodeR left, right;
        TreeNodeR(int x) {
            val = x;
        }
    }

    public class RightView {
        public static List<Integer> rightview(TreeNodeR root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNodeR> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNodeR curr = q.poll();

                    // first node of this level
                    if (i == levelSize-1) {
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
            TreeNodeR root = new TreeNodeR(1);
            root.left = new TreeNodeR(2);
            root.right = new TreeNodeR(3);
            root.left.right = new TreeNodeR(5);
            root.right.right = new TreeNodeR(4);
            root.left.right.left = new TreeNodeR(7);

            List<Integer> view = rightview(root);
            System.out.println("Left View: " + view);
        }
    }
