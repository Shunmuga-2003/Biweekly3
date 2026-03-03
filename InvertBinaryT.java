package BinaryTrees;

class Invert{
    Invert right;
    Invert left;
    int val;
    public Invert(int values){
        this.val=values;
        left=null;
        right=null;
    }
}
public class InvertBinaryT {
    public  static Invert inverttree(Invert node){
        if(node==null){
            return node;
        }
        Invert lh=inverttree(node.left);
        Invert rh=inverttree(node.right);
        node.left=rh;
        node.right=lh;
        return node;
    }

    public static void main(String[] args) {
        Invert root=new Invert(1);
        root.left=new Invert(2);
        root.right=new Invert(3);
        root.left.left=new Invert(4);
        root.left.right=new Invert(5);
        root.right.left=new Invert(6);
        root.right.right=new Invert(7);

    }
}
