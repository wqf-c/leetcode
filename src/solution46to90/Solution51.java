package solution46to90;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/3/2
 * Time: 22:44
 */
public class Solution51 {

  static int max;
  static List<List<String>> result;
  static int[] array;
  public List<List<String>> solveNQueens(int n) {
    result = new ArrayList<>();
    max = n;
    array = new int[max];
    check(0);
    return result;
  }

  public static void check(int n){
    if(n == max){
      List<String> list = new ArrayList<>();
      for(int i = 0; i < max; ++i){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < max; ++j){
          if(j == array[i]) sb.append('Q');
          else sb.append('.');
        }
        list.add(sb.toString());
      }
      result.add(list);
      return;
    }
    for(int i = 0; i < max; ++i){
      array[n] = i;
      if(judge(n)){
        check(n + 1);
      }
    }
  }

  public static boolean judge(int n){
    for(int i = 0; i < n; ++i){
      if(array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])){
        return false;
      }
    }
    return true;
  }
}
