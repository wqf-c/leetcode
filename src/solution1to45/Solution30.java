package solution1to45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/18
 * Time: 22:37
 */
public class Solution30 {
  //参照官方解题，滑动窗口的方法

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if(s.isEmpty() || words.length == 0) return result;
    int wordLen = words[0].length();
    int allLength = wordLen * words.length;
    int wordNum = words.length;
    if(s.length() < allLength) return result;
    HashMap<String, Integer> map = new HashMap<>();
    for(String word : words){
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    for(int i = 0; i < wordLen; ++i){
      int left = i;
      int right = i;
      int count = 0;
      HashMap<String, Integer> m = new HashMap<>();
      while (right + wordLen <= s.length()){
        String rigntWord = s.substring(right, right + wordLen);
        right += wordLen;
        if(!map.containsKey(rigntWord)){
          left = right;
          count = 0;
          m.clear();
        }else{
          count ++;
          m.put(rigntWord, m.getOrDefault(rigntWord, 0) + 1);
          while (m.getOrDefault(rigntWord, 0) > map.getOrDefault(rigntWord, 0)){
            String leftWord = s.substring(left, left + wordLen);
            count --;
            m.put(leftWord, m.getOrDefault(leftWord, 0) - 1);
            left += wordLen;
          }
          if(count == wordNum) result.add(left);
        }
      }
    }
    return result;
  }
}
