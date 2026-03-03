package BinaryTrees;

import java.util.*;

class TreeNodeb{
    int val;
    TreeNodeb left;
    TreeNodeb right;
    public TreeNodeb(int value){
        this.val=value;
        left=null;
        right=null;
    }
}
public class BoundaryTraversal {
    public  static boolean isLeaf(TreeNodeb node){
        return node.left==null && node.right==null;
    }
    public static void leftnode(TreeNodeb node,ArrayList<Integer> ans){
        TreeNodeb cur=node.left;
        while (cur!=null){
            if(isLeaf(cur)==false) ans.add(cur.val);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    public static void leaf(TreeNodeb node,ArrayList<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.val);
            return;
        }
        if(node.left!=null) leaf(node.left,ans);
        if(node.right!=null) leaf(node.right,ans);

    }
    public static void rightnode(TreeNodeb node,ArrayList<Integer> ans) {
        TreeNodeb cur = node.right;
        Stack<Integer> s = new Stack<>();
        while (cur != null) {
            if (isLeaf(cur) == false) s.push(cur.val);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }
    }
   public static ArrayList<Integer> boundaryTraversal(TreeNodeb node) {
        ArrayList<Integer> ans=new ArrayList<>();
       if(isLeaf(node)==false) ans.add(node.val);
       leftnode(node,ans);
       leaf(node,ans);
       rightnode(node,ans);
       return  ans;
    }
    public static void main(String[] args) {
        TreeNodeb node=new TreeNodeb(10);
        node.left=new TreeNodeb(20);
        node.right=new TreeNodeb(30);
        node.left.left=new TreeNodeb(40);
        node.left.left.left=new TreeNodeb(50);
        node.right.right=new TreeNodeb(60);
        node.right.right.right=new TreeNodeb(70);
        ArrayList<Integer> fin=boundaryTraversal(node);
        System.out.println(fin.toString());

    }
}
