package BinaryTrees;
class TreeNodeC{
    int val;
    TreeNodeC left;
    TreeNodeC right;
    public TreeNodeC(int data){
        val=data;
        this.left=null;
        this.right=null;
    }
}
public class Childsum {
    public static int childsum(TreeNodeC node) {
        if (node == null || (node.left == null) && (node.right == null)) {
            return 1;
        }
        int sum = 0;
        if (node.left != null) {
            sum += node.left.val;
        }
        if (node.right != null) {
            sum += node.right.val;
        }

        return ((node.val == sum) && (childsum(node.left) == 1) && (childsum(node.right) == 1)) ? 1 : 0;
    }
    public static void main(String[] args) {
        TreeNodeC root = new TreeNodeC(10);
        root.right = new TreeNodeC(5);
        root.left = new TreeNodeC(5);
        root.left.left=new TreeNodeC(2);
        root.left.right=new TreeNodeC(3);
        root.right.left=new TreeNodeC(2);
        root.right.right=new TreeNodeC(3);
        int x = childsum(root);
        System.out.println(x);
    }
}
