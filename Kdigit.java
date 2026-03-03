package BinaryTrees;

import java.util.*;

class NodeK{
    int val;
    NodeK left;
    NodeK right;
    public NodeK(int value){
        this.val=value;
        left=right=null;
    }
}

public class Kdigit {
    public  static List<Integer> distanceK(NodeK root, NodeK target, int k) {
        Map<Integer,NodeK> parent=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        Queue<NodeK> queue=new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                NodeK cur=queue.poll();
                if(cur.left!=null){
                    parent.put(cur.left.val,cur);
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    parent.put(cur.right.val,cur);
                    queue.offer(cur.right);
                }
            }
        }
        Map<Integer,Integer> m=new HashMap<>();
        queue.offer(target);

        while (k>0 && !queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                NodeK cur=queue.poll();
                m.put(cur.val, 1);
                if( cur.left!=null && !m.containsKey(cur.left.val)){
                    queue.offer(cur.left);
                }
                if( cur.right!=null && !m.containsKey(cur.right.val)){
                    queue.offer(cur.right);
                }
                if(parent.containsKey(cur.val) && !m.containsKey(parent.get(cur.val).val)){
                    queue.offer(parent.get(cur.val));
                }
            }
            k--;
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }

    public static void main(String[] args) {
        NodeK root=new NodeK(3);
        root.left=new NodeK(5);
        root.right=new NodeK(1);
        root.left.left=new NodeK(6);
        root.left.right=new NodeK(2);
        root.left.right.left=new NodeK(7);
        root.left.right.right=new NodeK(4);
        List<Integer> ans=distanceK(root,root.left,2);
        System.out.println(ans.toString());
    }
}

