package solution1to45;

import java.util.Arrays;

/**
 * Author: wqf
 * Date: 2020/2/1
 * Time: 20:51
 */
public class Solution6 {
  public String convert(String s, int numRows) {
    if(s == null || s.length() <= numRows || numRows <= 1){
      return s;
    }
    int len = s.length();
    char[] result = new char[len];
    int count = 0;
    for(int i = 0; i < len; i += 2*numRows - 2){
      result[count] = s.charAt(i);
      count ++;
    }
    for(int i = 1; i < numRows - 1; ++i){
      int k = 0;
      for(int j = i; j < len; ){
        result[count] = s.charAt(j);
        count ++;
        if(k % 2 == 0){
          j += (numRows-1-i)*2;
        }else{
          j += 2*i;
        }
        k ++;
      }
    }
    for(int i = numRows - 1; i < len; i += 2*numRows - 2){
      result[count] = s.charAt(i);
      count ++;
    }
    return new String(result);
  }
}
