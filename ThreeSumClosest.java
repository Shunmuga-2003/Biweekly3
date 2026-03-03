package ZohoTharuvai.Biweekly3;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums,int target){
        int mindiff=Integer.MAX_VALUE;
        int closestsum=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int diff=Math.abs(target-sum);
                if(diff<mindiff){
                    mindiff=diff;
                    closestsum=sum;
                }
                if(sum<target){
                    j++;
                }
                else if(sum>target){
                    k--;
                }else{
                    return sum;
                }

            }
        }
        return closestsum;
    }
}
