package solution46to90;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/3/2
 * Time: 23:53
 */
public class Solution52 {

  static int max;
  static int totalCount = 0;
  static int[] array;

  public static void main(String[] args) {
    System.out.println(totalNQueens(1));
  }
  public static int totalNQueens(int n) {
    max = n;
    array = new int[max];
    check(0);
    return totalCount;
  }

  public static void check(int n){
    if(n == max){
      totalCount ++;
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
