package BinaryTrees;
class TreeNodeLs{
    int value;
    TreeNodeLs left;
    TreeNodeLs right;
    public TreeNodeLs(int values){
        this.value=values;
        left=right=null;
    }
}
public class LengthofLeftRight {
    public static int countNodes(TreeNodeLs root) {
        if (root == null) return 0;

        int lh = left(root);
        int rh = right(root);
        if(lh==rh)  return  (2<<lh)-1;

        return 1+(left(root.left))+right(root.right);
    }

    public static int left(TreeNodeLs root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public static int right(TreeNodeLs root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNodeLs root=new TreeNodeLs(1);
        root.left=new TreeNodeLs(2);
        root.right=new TreeNodeLs(3);
        root.left.left=new TreeNodeLs(4);
        root.left.right=new TreeNodeLs(5);
        root.right.left=new TreeNodeLs(6);
        root.right.right=new TreeNodeLs(7);
        int val=countNodes(root);
        System.out.println(val);
    }
}
