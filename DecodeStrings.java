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
        return helper(index, s, dp);
    }

    private static int helper(int index, String s, Integer[] dp) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (dp[index] != null) return dp[index];
        int count = 0;
        count += helper(index + 1, s, dp);
        if (index + 1 < s.length() &&
                (s.charAt(index) == '1' ||
                        (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {
            count += helper(index + 2, s, dp);
        }
        return dp[index] = count;
    }
}
