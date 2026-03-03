package BinaryTrees;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.val= value;
        left = null;
        right = null;
    }
}
public class PreorderTraversel {
    public static void preorder(TreeNode root,List<Integer> li){
        if(root==null){
            return;
        }
        li.add(root.val);
        preorder(root.left,li);
        preorder(root.right,li);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        preorder(root,li);
        return li;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(20);
        root.right=new TreeNode(30);
        root.left.left=new TreeNode(40);
        root.left.right=new TreeNode(50);
        root.right.left=new TreeNode(60);
        root.right.right=new TreeNode(70);
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
