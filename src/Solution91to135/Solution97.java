package Solution91to135;

import java.util.HashMap;
import java.util.Map;

public class Solution97 {

    //todo 优化
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s3.length(); ++i){
            char c = s3.charAt(i);
            if(!map.containsKey(s3.charAt(i))){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        String temp = s1 + s2;
        for(int i = 0; i < temp.length(); ++i){
            char c = temp.charAt(i);
            if(!map.containsKey(c)) return false;
            else{
                if(map.get(c) <= 0) return false;
                else map.put(c, map.get(c) - 1);
            }
        }

        return judge(s1, 0, s2, 0, s3, 0);
    }

    public boolean judge(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index){
        if (s3Index == s3.length()) return true;
        char c3 = s3.charAt(s3Index);
        if(s1Index == s1.length()) return s3.substring(s3Index).equals(s2.substring(s2Index));
        if(s2Index == s2.length()) return s3.substring(s3Index).equals(s1.substring(s1Index));
        if(s2Index < s2.length()) {
            char c2 = s2.charAt(s2Index);
            if(c3 == c2 && judge(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1)) return true;
        }
        if(s1Index < s1.length()){
            char c1 = s1.charAt(s1Index);
            if(c3 == c1 && judge(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1)) return true;
        }
        return false;
    }

    public static void main(String[] argv){
        Solution97 s = new Solution97();
        System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
