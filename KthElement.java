package BinaryTrees;
import java.util.*;
class Tree{
    int val;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.val = data;
    }
}
public class KthElement {
    public List<Integer> distanceK(Tree root, Tree target, int k) {
        Map<Integer, Tree> parent = new HashMap<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        // Build parent map
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                parent.put(node.left.val, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                parent.put(node.right.val, node);
            }
        }

        Map<Tree, Boolean> visitedMap = new HashMap<>();
        queue.clear();
        queue.offer(target);
        visitedMap.put(target, true);

        // BFS level-wise
        while (k > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Tree node = queue.poll();
                if (node.left != null && !visitedMap.containsKey(node.left)) {
                    queue.offer(node.left);
                    visitedMap.put(node.left, true);
                }
                if (node.right != null && !visitedMap.containsKey(node.right)) {
                    queue.offer(node.right);
                    visitedMap.put(node.right, true);
                }
                if (parent.containsKey(node.val) &&
                        !visitedMap.containsKey(parent.get(node.val))) {
                    queue.offer(parent.get(node.val));
                    visitedMap.put(parent.get(node.val), true);
                }
            }
            k--;
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }

        return ans;
    }
}
    class KthMain {
        public static void main(String[] args) {
            Tree root = new Tree(3);
            root.left = new Tree(5);
            root.right = new Tree(1);
            root.left.left = new Tree(6);
            root.left.right = new Tree(2);
            root.left.right.left = new Tree(7);
            root.left.right.right = new Tree(4);
            root.right.left = new Tree(0);
            root.right.right = new Tree(8);
            KthElement element = new KthElement();
            List<Integer> ans = element.distanceK(root, root.left, 2);
            System.out.println(Collections.min(ans));
            System.out.println(ans);
        }
    }