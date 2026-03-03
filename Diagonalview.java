package BinaryTrees;
import java.util.*;
import java.lang.*;

class Noded{
    int val;
    Noded left, right;
    public Noded(int value) {
        this.val = value;
        left = right = null;
    }
}

class Paird{
    Noded n;
    int diagonal;
    public Paird(Noded n, int v) {
        this.n = n;
        this.diagonal = v; // ✅ Fixed assignment
    }
}

public class Diagonalview {
    public static ArrayList<Integer> diagonal(Noded root) {
        Queue<Paird> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        q.offer(new Paird(root, 0));

        while (!q.isEmpty()) {
            Paird cur = q.poll();
            Noded node = cur.n;
            int dia = cur.diagonal;

            mp.computeIfAbsent(dia, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                q.add(new Paird(node.left, dia + 1));
            }
            if (node.right != null) {
                q.add(new Paird(node.right, dia));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> list : mp.values()) {
            result.addAll(list);
        }

        return result;
    }

    public static void main(String[] args) {
        Noded root = new Noded(10);
        root.left = new Noded(20);
        root.right = new Noded(30);
        root.left.left = new Noded(40);
        root.right.left = new Noded(50);
        root.right.right = new Noded(60);

        ArrayList<Integer> result = diagonal(root);
        System.out.println(result);
    }
}
