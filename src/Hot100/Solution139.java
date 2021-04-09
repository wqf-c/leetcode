package Hot100;

import java.util.*;

/**
 * @author wqf
 * @date 2021/4/6 23:38
 * @Email:284660487@qq.com
 */
public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); ++i){
            for(int j = 0; j < i; ++j){
                if(!dp[j]) continue;
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        if(s.length()==0)return true;
        if(s.length()>150)return false;
        for(int i=0;i<wordDict.size();i++){
            String word=wordDict.get(i);
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()),wordDict))
                    return true;
            }
        }
        return false;
    }

}
