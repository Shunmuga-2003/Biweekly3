package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodew{
    int val;
    TreeNodew left;
    TreeNodew right;
    public TreeNodew(int value){
        this.val=value;
        left=null;
        right=null;
    }
}
class pair{
    TreeNodew node;
    int id;
    public pair(TreeNodew nodes, int ids){
        this.node=nodes;
        this.id=ids;
    }
}
public class WidthofBT {
    public static  int widthOfBinaryTree(TreeNodew root) {
        if(root==null){
            return 0;
        }
        Queue<pair> qu=new LinkedList<>();
        int ans=0;
        qu.offer(new pair(root,0));
        while (!qu.isEmpty()){
            int size= qu.size();
            int min=qu.peek().id;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++) {
                int cur_id = qu.peek().id - min;
                TreeNodew node = qu.peek().node;
                qu.poll();

                if (i == 0) first = cur_id;
                if (i == size - 1) last = cur_id;
                if (node.left != null) qu.offer(new pair(node.left, cur_id * 2 + 1));
                if (node.right != null) qu.offer(new pair(node.right, cur_id * 2 + 2));
            }
            ans=Math.max(ans,last-first+1);
            }
        return ans;
        }

    public static void main(String[] args) {
        TreeNodew root=new TreeNodew(10);
        root.left=new TreeNodew(20);
        root.right=new TreeNodew(30);
        root.left.left=new TreeNodew(40);
        root.left.right=new TreeNodew(50);
        root.right.left=new TreeNodew(60);
        root.right.right=new TreeNodew(70);
        root.left.left.left=new TreeNodew(80);
        root.right.right.right=new TreeNodew(90);
        int ans=widthOfBinaryTree(root);
        System.out.println(ans);
    }
}

