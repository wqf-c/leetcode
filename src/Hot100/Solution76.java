package Hot100;

/**
 * @author wqf
 * @date 2021/3/27 10:47
 * @Email:284660487@qq.com
 */
public class Solution76 {

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] tAscii = new int[128];
        int require = 0, format = 0;
        for(int i = 0; i < t.length(); ++i){
            if(tAscii[t.charAt(i)] == 0) require++;
            tAscii[t.charAt(i)]++;
        }
        int[] sAscii = new int[128];
        char[] chars = s.toCharArray();
        int[] ans = {-1, -1};
        int left = 0, right = 0;
        for(int i = 0; i < chars.length; ++i){
            int count = sAscii[chars[i]] + 1;
            sAscii[chars[i]] = count;
            if(tAscii[chars[i]] == count){
                format ++;
            }
            //去掉最左边的一个在t中的字符
            while (format == require && left <= right){
                if(ans[0] == -1 || right - left < ans[1] - ans[0]){
                    ans[0] = left;
                    ans[1] = right;
                }
                if(tAscii[chars[left]] != 0 && tAscii[chars[left]] == sAscii[chars[left]]){
                    format--;
                }
                sAscii[chars[left]]--;
                left++;
            }
            right++;
        }
        if(ans[0] == -1) return "";
        else return s.substring(ans[0], ans[1] + 1);
    }


}
