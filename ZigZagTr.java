package BinaryTrees;

import java.util.*;

class Nodez{
    int val;
    Nodez left;
    Nodez right;
    public Nodez(int value){
        this.val=value;
        left=null;
        right=null;
    }
}
public class ZigZagTr {
    public  static  List<List<Integer>> zig(Nodez root){
        Queue<Nodez> qu=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        qu.offer(root);
        boolean LeftRight=true;
        while (!qu.isEmpty()){
            int size= qu.size();
            Integer[] arr=new Integer[size];
            for(int i=0;i<size;i++) {
                Nodez x = qu.poll();
                int index = (LeftRight) ? i : size - i - 1;
                arr[index] = x.val;
                if (x.left != null) qu.offer(x.left);
                if (x.right != null) qu.offer(x.right);
            }
            LeftRight=!LeftRight;
            res.add((Arrays.asList(arr)));
        }
        return res;
    }
        public static void main(String[] args) {
        Nodez root=new Nodez(10);
        root.left=new Nodez(20);
        root.right=new Nodez(30);
        root.left.left=new Nodez(40);
        root.left.right=new Nodez(50);
        root.right.left=new Nodez(60);
        root.right.right=new Nodez(70);

        List<List<Integer>> ans=zig(root);
            for(List<Integer> s: ans){
                System.out.println(s+" ");
            }
    }
}
