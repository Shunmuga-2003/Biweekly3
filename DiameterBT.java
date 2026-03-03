package BinaryTrees;
class NodeD{
    int val;
    NodeD left;
    NodeD right;
    public NodeD(int value){
        this.val=value;
        left=null;
        right=null;
    }
}
public class DiameterBT {
    static int maxi=0;
    public static int diameterOfBinaryTree(NodeD root) {
        diameter(root);
        return maxi;
    }
    public static int diameter(NodeD root){
        if (root == null) return 0;

        int lh = diameter(root.left);
        int rh = diameter(root.right);

        maxi = Math.max(maxi, lh + rh); // This only updates local copy of maxi
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        NodeD root=new NodeD(10);
        root.left=new NodeD(20);
        root.right=new NodeD(30);
        root.right.left=new NodeD(40);
        root.right.right=new NodeD(50);
        root.right.left.left=new NodeD(50);
        root.right.right.right=new NodeD(70);
        int values=diameterOfBinaryTree(root);
        System.out.println(values);
    }
}


