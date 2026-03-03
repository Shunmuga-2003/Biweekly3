package BinaryTrees;
import java.util.ArrayList;
import java.util.List;


class Node {
    int val;
    Node left;
    Node right;

    public Node(int value) {
        this.val= value;
        left = null;
        right = null;
    }
}

public class PostOrderTraversal {
    public static void postorder(Node root,List<Integer> li){
        if(root==null){
            return;
        }

        postorder(root.left,li);
        postorder(root.right,li);
        li.add(root.val);
    }
    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> li=new ArrayList<>();
        postorder(root,li);
        return li;
    }
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.right=new Node(50);
        root.left.left=new Node(40);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        List<Integer> result = preorderTraversal(root);
        System.out.println(result.toString());

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
