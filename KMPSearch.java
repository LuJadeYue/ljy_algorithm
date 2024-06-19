public class KMPSearch {

    // 构建部分匹配表
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        int j = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP搜索算法
    public static void kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // text的索引
        int j = 0; // pattern的索引

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // 继续搜索下一个匹配
            }
            // 已匹配的字符不匹配时
            else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // 使用部分匹配表回退
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        kmpSearch(text, pattern);
    }
}