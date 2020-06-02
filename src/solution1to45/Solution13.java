package solution1to45;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: wqf
 * Date: 2020/2/9
 * Time: 19:46
 */
public class Solution13 {

  public int romanToInt(String s) {
    int result = 0;
    Map<String, Integer> map = new HashMap<String, Integer>();
    int temp = 0;
    int value = 0;
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    for(int index = s.length() - 1; index >= 0; --index){
      value = map.get(s.substring(index, index + 1));
      if(temp > value) result -= value;
      else{
        result += value;
        temp = value;
      }
    }
    return result;
  }
}
