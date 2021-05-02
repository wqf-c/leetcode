package Hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wqf
 * @date 2021/4/24 11:18
 * @Email:284660487@qq.com
 */
public class Solution438 {

    public boolean check(int[] a, int[] b){
        for(int i = 0; i < 26; ++i){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if(p.length() > s.length()){
            return rst;
        }
        int[] sNum = new int[26];
        int[] pNum = new int[26];
        for(int i = 0; i < p.length(); ++i){
            pNum[p.charAt(i) - 'a'] ++;
            sNum[s.charAt(i) - 'a'] ++;
        }
        if(check(pNum, sNum)){
            rst.add(0);
        }
        for(int i = p.length(); i < s.length(); ++i){
            sNum[s.charAt(i) - 'a']++;
            sNum[s.charAt(i - p.length()) - 'a']--;
            if(check(sNum, pNum)){
                rst.add(i - p.length() + 1);
            }
        }
        return rst;

    }

}
