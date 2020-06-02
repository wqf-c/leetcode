package solution46to90;

import java.util.*;

/**
 * Author: wqf
 * Date: 2020/2/28
 * Time: 2:50
 */
public class Solution49 {

  public static void main(String[] args) {
//    Map<Character, Integer> map = new HashMap<>();
//    map.put('c', 1);
//    Integer i1 = 100;
//    Integer i2 = 100;
//    System.out.println(i1 == i2);
//    System.out.println(map.containsKey('c'));

    System.out.println(judge("boo", "bob"));
  }

  ////超时
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    if(strs.length == 0) return result;
    for(String str: strs){
      boolean flag = false;
      for(List<String> l : result){
        if(judge(l.get(0), str)){
          l.add(str);
          flag = true;
          break;
        }
      }
      if(!flag){
        List<String> l = new ArrayList<>();
        l.add(str);
        result.add(l);
      }
    }
    return result;
  }

  public static boolean judge(String s1, String s2){
    if(s1.length() != s2.length()) return false;
    else{
      Map<Character, Integer> map1 = new HashMap<>();
      Map<Character, Integer> map2 = new HashMap<>();
      for(int i = 0; i < s1.length(); ++i){
        char ch = s1.charAt(i);
      //  System.out.println(ch);
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);
      }
      for(int i = 0; i < s2.length(); ++i){
        char ch = s2.charAt(i);
        map2.put(ch, map2.getOrDefault(ch, 0) + 1);
      }
      if(map1.keySet().size() != map2.keySet().size()) return false;
      for(Map.Entry<Character, Integer> entry : map1.entrySet()){
        char c = entry.getKey();
       // System.out.println(c + "  " + map2.get(c) + "  " + entry.getValue());
        if(!map2.containsKey(c) || !map2.get(c).equals(entry.getValue())){
          return false;
        }
      }
    }
    return true;
  }

  public List<List<String>> groupAnagrams1(String[] strs){
    Map<String, List<String>> map = new HashMap<>();
    for(String str : strs){
      char[] chs = str.toCharArray();
      Arrays.sort(chs);
      String key = String.valueOf(chs);
      if(map.containsKey(key)){
        map.get(key).add(str);
      }else{
        List<String> l = new ArrayList<>();
        l.add(str);
        map.put(key, l);
      }
    }
    return new ArrayList<>(map.values());
  }
}
