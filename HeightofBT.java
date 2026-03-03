package BinaryTrees;
class NodeH{
    int val;
    NodeH left;
    NodeH right;
    public NodeH(int value){
        this.val=value;
        left=null;
        right=null;
    }
}
public class HeightofBT{
    public static int height(NodeH root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return 1+(Math.max(lh,rh));
    }
    public static void main(String[] args) {
        NodeH root=new NodeH(10);
        root.left=new NodeH(20);
        root.right=new NodeH(30);
        root.left.left=new NodeH(40);
        root.left.right=new NodeH(50);
        int val=height(root);
        System.out.println("The height of the tree is= "+val );
    }
}
