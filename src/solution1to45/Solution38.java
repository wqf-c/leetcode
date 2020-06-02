package solution1to45;

import java.util.Arrays;

/**
 * Author: wqf
 * Date: 2020/2/20
 * Time: 18:55
 */
public class Solution38 {

  public static void main(String[] args) {
    System.out.println(countAndSay(4));
  }

  //减少string的赋值操作时间由23ms -> 2ms
//  public static String countAndSay(int n) {
//    if(n == 1) return "1";
//    String res = "";
//    String lastRes = "1";
//    for(int i = 2; i <= n; ++i){
//      int count = 1;
//      for(int j = 0; j < lastRes.length(); ++j){
//        if(j == lastRes.length() - 1 || lastRes.charAt(j) != lastRes.charAt(j + 1)){
//          res =  res + count + lastRes.substring(j, j + 1);
//          count = 1;
//        }else{
//          count ++;
//        }
//      }
//      lastRes = res;
//      if(i != n) res = "";
//    }
//    return res;
//  }
  public static String countAndSay(int n) {
    if(n == 1) return "1";
    String[] save = new String[31];
    save[1] = "1";
    for(int i = 2; i <= n; ++i){
      int count = 0;
      StringBuilder sb = new StringBuilder();
      char[] s = save[i - 1].toCharArray();
      char cur = s[0];
      for(char c : s){
        if(c != cur){
          sb.append(count).append(cur);
          count = 1;
          cur = c;
        }else{
          count ++;
        }
      }
      sb.append(count).append(cur);
      save[i] = sb.toString();
    }
    return save[n];
  }

  //递归为什么会快那么多
}
