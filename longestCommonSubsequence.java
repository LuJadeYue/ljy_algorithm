public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        longestCommonSubsequence obj = new longestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }
}
