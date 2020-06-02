package solution1to45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/15
 * Time: 0:02
 */
public class Solution22 {

//  public static List<String> result = new ArrayList<>();
//
//  public static void main(String[] args) {
//    Solution22 s22 = new Solution22();
//    s22.generateParenthesis(1);
//    for (String s:
//         result) {
//      System.out.println(s);
//    }
//
//  }
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if(n == 0){
      return result;
    }
    gen(n, n, "", result);
    return result;
  }

  public void gen(int leftL, int leftR, String s, List<String> result){
    if(leftL < 0 || leftR < 0){
      return;
    }
    if(leftL == 0 && leftR == 0){
      result.add(s);
    }else if(leftL == leftR){
      gen(leftL - 1, leftR, s + "(", result);
    }else if(leftL < leftR && leftL > 0){
      gen(leftL - 1, leftR, s+"(", result);
      gen(leftL, leftR - 1, s+")", result);
    }else if(leftL < leftR && leftL == 0){
      gen(leftL, leftR - 1, s + ")", result);
    }
    return;
  }
}
