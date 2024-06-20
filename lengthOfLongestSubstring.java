import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        //滑动窗口
        Set<Character> set = new HashSet<Character>();
        int left = 0;
        int max = 0;
        for(int right = 0 ;right < s.length();right++){
            char ch = s.charAt(right);
            //如果set中包含这个字符，那么就一直删除左指针的字符，直到不包含这个字符
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            //更新最大值
            max = Math.max(max,right - left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring obj = new lengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
