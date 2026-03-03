package BinaryTrees;
class TreenodePa {
    int val;
    TreenodePa left;
    TreenodePa right;
    public TreenodePa(int value){
        this.val=value;
        left=right=null;
    }
}


public class MaximumPathsum {
    public static int maxPathSum(TreenodePa root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maximum(root, maxi);
        return maxi[0];
    }
    public static int maximum(TreenodePa root,int[] maxi){
        if(root==null){
            return 0;
        }
        int left = Math.max(0, maximum(root.left, maxi));
        int right = Math.max(0, maximum(root.right, maxi));

        // Update the global max if this path through root is better
        maxi[0] = Math.max(maxi[0], left + right + root.val);

        // Return best single path going up
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreenodePa root=new TreenodePa(1);
        root.left=new TreenodePa(2);
        root.right=new TreenodePa(3);
        root.right.left=new TreenodePa(4);
        root.right.right=new TreenodePa(5);
        int ans=maxPathSum(root);
        System.out.println(ans);
    }
}

