package String;

import java.util.HashSet;

/**
 * @author wqf
 * @date 2020/10/20 21:27
 * @Email:284660487@qq.com
 */
public class Solution859 {

    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() < 2) return false;
        boolean sameFlag = false;
        int[] count = new int[26];
        int diff1 = -1, diff2 = -1;
        for(int i = 0; i < A.length(); ++i){
            if(!sameFlag){
                if(count[A.charAt(i) - 'a'] != 0) sameFlag = true;
                else count[A.charAt(i) - 'a'] = 1;
            }
            if(A.charAt(i) != B.charAt(i)) {
                if(diff1 == -1) diff1 = i;
                else if(diff2 == -1){
                    diff2 = i;
                    if(A.charAt(diff1) != B.charAt(diff2) || A.charAt(diff2) != B.charAt(diff1)) return false;
                }else return false;
            }
        }
        if(diff1 == -1 && diff2 == -1){
            return sameFlag;
        }else if(diff1 == -1 || diff2 == -1) return false;

        return true;
    }
}
