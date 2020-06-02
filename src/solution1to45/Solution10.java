package solution1to45;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Author: wqf
 * Date: 2020/2/5
 * Time: 21:17
 */
public class Solution10 {

  public static boolean isMatch(String s, String p) {
    if(p.isEmpty()) return s.isEmpty();

    boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
    System.out.println(firstMatch);
    if(p.length() >= 2 && p.charAt(1) == '*'){
      return (isMatch(s, p.substring(2)) ||
        (firstMatch && isMatch(s.substring(1), p)));
    }else{
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
  }

  public static void main(String[] args) {

    System.out.println(isMatch("aa", "a*"));
  }
}
