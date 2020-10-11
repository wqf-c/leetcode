package String;

/**
 * @author wqf
 * @date 2020/10/11 11:05
 * @Email:284660487@qq.com
 */
public class Solution459 {

    public boolean repeatedSubstringPattern(String s) {
        String pattern = "";
        for(int i = 0; i < s.length()/2; ++i){
            pattern += s.charAt(i);
            if(s.length() % pattern.length() == 0){
                int j = i + 1;
                for(int k = 0; j < s.length(); ++j){
                    if(s.charAt(j) != pattern.charAt(k)) break;
                    if(k == pattern.length() - 1) k = 0;
                    else k++;
                }
                if(j == s.length()) return true;
            }
        }
        return false;
    }

}
