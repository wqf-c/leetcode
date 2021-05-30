package CodeTop;

/**
 * @author wqf
 * @date 2021/5/18 0:15
 * @Email:284660487@qq.com
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        String rst = s.substring(0, 1);
        int max = 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); ++i){
            int left = i - 1, right = i + 1;
            for(; left >= 0 && right < s.length() &&chars[left] == chars[right]; -- left, ++right);
            int len1 = right - left - 1;
            if(len1 > max){
                max = len1;
                rst = s.substring(left + 1, right);
            }
            left = i;
            right = i + 1;
            for(;left >= 0 && right < s.length() && chars[left] == chars[right]; --left, ++right);
            int len2 = right - left - 1;
            if(len2 > max){
                max = len2;
                rst = s.substring(left + 1, right);
            }
        }


        return rst;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("bbb"));
    }

}
