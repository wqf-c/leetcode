package solution1to45;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Author: wqf
 * Date: 2020/1/31
 * Time: 22:37
 */
public class Solution5 {

//  public static String longestPalindrome(String s) {
//
//    String result = "";
//    int maxLength = 0;
//    int flag = 0;
//    if(s.length() == 1){
//      return s;
//    }
//    for(int i = 1; i < s.length(); ++i){
//      flag = 0;
//      for(int j = 1; i - j >= 0 && i + j <= s.length()-1; ++j){
//        if(s.charAt(i - j) != s.charAt(i + j) ||  i - j == 0 || i + j == s.length()-1){
//          if((i - j == 0 || i + j  == s.length()-1) && s.charAt(i - j) == s.charAt(i + j)){
//            flag = j;
//          }else{
//            flag = j - 1;
//          }
//          break;
//        }
//      }
//
//      if(flag * 2 + 1 > maxLength){
//        maxLength = flag * 2 + 1;
//        result = s.substring(i - flag, i + flag + 1);
//      }
//    }
//
//    for(int i = 1; i < s.length(); ++i){
//      flag = 0;
//      for(int j = 1; i - j >= 0 && i + j - 1 <= s.length()-1; ++j){
//        if(s.charAt(i - j) != s.charAt(i + j - 1) || i - j == 0 || i + j - 1 == s.length()-1){
//          if((i - j == 0 || i + j - 1 == s.length() - 1) && s.charAt(i - j) == s.charAt(i + j - 1)){
//            flag = j;
//          }else{
//            flag = j - 1;
//          }
//          break;
//        }
//      }
//      if(flag * 2 > maxLength){
//        maxLength = flag * 2 ;
//        result = s.substring(i - flag, i + flag);
//      }
//    }
//
//    return result;
//  }

  public static String longestPalindrome(String s) {
    String result = "";
    int[] limit = {0, 0};
    char[] ch = s.toCharArray();
    int i = 0;
    while (i < ch.length) {
      i = indexOf(ch, i, limit);
    }
    result = s.substring(limit[0], limit[1]);
    return result;
  }

  public static int indexOf(char[] ch, int low, int[] limit) {
    int high = low + 1;
    while (high < ch.length && ch[high] == ch[low]) {
      high++;
    }
    int result = high;
    while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
      low--;
      high++;
    }

    if (high - low > limit[1] - limit[0]) {
      limit[0] = low;
      limit[1] = high;
    }
    return result;
  }

  //动态规划


  public static void main(String[] args) {
    System.out.println(longestPalindrome("caba"));
  }

}
