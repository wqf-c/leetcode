package String;

/**
 * @author wqf
 * @date 2020/10/7 22:20
 * @Email:284660487@qq.com
 */
public class Solution3 {

    public static int lengthOfLongestSubstring1(String s) {
        int max = 1;
        int lastMax = max;
        int count = 0;
        if(s == null || s.length() == 0) return 0;
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) == s.charAt(i - 1)){
                lastMax = 1;
            }else{
                int j = i - 1;
                boolean flag = false;
                for(; j >=  i - lastMax; --j){
                    System.out.println(count);
                    count++;
                    if(s.charAt(j) == s.charAt(i)){
                        flag = true;
                        break;
                    }
                }
                if(!flag) lastMax += 1;
                else lastMax = i - j;
                if(lastMax > max) max = lastMax;

            }
      //      System.out.println(lastMax);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s){
        int[] cache = new int[128];
        for(int i = 0; i < cache.length; ++i){
            cache[i] = -1;
        }
        int max = 0;
        int lastMax = 0;
        for(int i = 0; i < s.length(); ++i){
            int len = 0;
            int index = s.charAt(i);
            if(cache[index] == -1) len = lastMax + 1;
            else len = Math.min(lastMax + 1, i - cache[index]);
            lastMax = len;
            cache[s.charAt(i)] = i;
            max = Math.max(max,len);
        }
        return max;
    }

    public static void main(String[] args){
        lengthOfLongestSubstring("abcabcbb");
    }
}
