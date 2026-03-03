package ZohoTharuvai.Biweekly3;

import java.util.Arrays;

public class DecodeStrings {
    public static void main(String[] args) {
        String s = "112";
        Integer[] dp = new Integer[s.length()];
        System.out.println(decode(0, s, dp));
        System.out.println(Arrays.toString(dp));
    }
    public static int decode(int index, String s, Integer[] dp) {
        int[] tabulation=new int[s.length()+1];
        tabulation[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                tabulation[i]=0;
            }
            else{
                tabulation[i]+=tabulation[i+1];
                if(i+1<s.length() && (s.charAt(i)=='1' || s.charAt(i)=='2') && s.charAt(i+1)<='6'){
                    tabulation[i]+=tabulation[i+2];
                }
            }
        }

        return tabulation[0];
    }
    private static int memoization(int index, String s, Integer[] dp) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (dp[index] != null) return dp[index];
        int count = 0;
        count += memoization(index + 1, s, dp);
        if (index + 1 < s.length() &&
                (s.charAt(index) == '1' ||
                        (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {
            count += memoization(index + 2, s, dp);
        }
        return dp[index] = count;
    }
}
