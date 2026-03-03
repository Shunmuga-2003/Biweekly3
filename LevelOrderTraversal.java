package BinaryTrees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class NodeL{
    int val;
    NodeL left;
    NodeL right;
    public NodeL(int value){
        this.val=value;
        left=null;
        right=null;
    }
}
public class LevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>>  level(NodeL root){
        Queue<NodeL> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        int size=q.size();
        while(!q.isEmpty()){
            ArrayList<Integer> ans1=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                ans1.add(q.poll().val);
            }
            ans.add(0,ans1);
        }
        return ans;
    }
    public static void main(String[] args) {
        NodeL root = new NodeL(1);
        root.left = new NodeL(3);
        root.right = new NodeL(2);
        root.left.left = new NodeL(5);
        root.left.right = new NodeL(6);
        root.right.left = new NodeL(7);
        root.right.right = new NodeL(8);
        ArrayList<ArrayList<Integer>> ans = level(root);
        System.out.println(ans.toString());

    }
}
