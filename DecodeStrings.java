package ZohoTharuvai.Biweekly3;

public class DecodeStrings {
    public static void main(String[] args) {
        String s="12";
        System.out.println(decode(0,s));
    }
    public static int decode(int index,String s){
        Integer[] dp=new Integer[s.length()];
        return helper(0, s,dp);
    }

    private static int helper(int index, String s,Integer[] dp) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if(dp[index]!=null) return dp[index];
        int count = 0;
        count += helper(index + 1, s,dp);
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += helper(index + 2, s,dp);
            }
        }
        return dp[index]=count;
    }
}
