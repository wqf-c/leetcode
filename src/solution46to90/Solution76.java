package solution46to90;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: wqf
 * Date: 2020/4/13
 * Time: 21:37
 */
public class Solution76 {

  public String minWindow(String s, String t) {
    if(s.length() < t.length()){
      return  "";
    }
    Map<Character, Integer> dict = new HashMap<>();
    for(int i = 0; i < t.length(); ++i){
      dict.put(t.charAt(i), dict.getOrDefault(t.charAt(i), 0) + 1);
    }
    Map<Character, Integer> wordCount = new HashMap<>();
    int required = dict.size();
    int format = 0;
    int[] ans = {-1, 0, 0};
    int l = 0, r = 0;
    for(int i = 0; i < s.length(); ++i){
      char c = s.charAt(i);
      int count = wordCount.getOrDefault(c, 0) + 1;
      if(dict.containsKey(c) && dict.get(c) == count){
        format ++;
      }
      wordCount.put(c, count);
      while (l <= r && format == required){
        if(ans[0] == -1 || r - l + 1 < ans[0]){
          ans[0] = r - l + 1;
          ans[1] = l;
          ans[2] = r;
        }
        char p = s.charAt(l);
        if(dict.containsKey(p) && dict.get(p).intValue() == wordCount.get(p).intValue()){
          format --;
        }
        wordCount.put(p, wordCount.get(p)-1);
        l++;
      }
      r++;
    }
    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }
}
