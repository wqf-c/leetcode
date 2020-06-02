package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/17
 * Time: 17:26
 */
public class Solution28 {

  public int strStr(String haystack, String needle) {
    if(needle.isEmpty()) return 0;
    if(haystack.isEmpty() || haystack.length() < needle.length()) return -1;
    int[] next = kmpNext(needle);
    for(int i = 0, j = 0; i < haystack.length(); i++) {

      while( j > 0 && haystack.charAt(i) != needle.charAt(j)) {
        j = next[j-1];
      }

      if(haystack.charAt(i) == needle.charAt(j)) {
        j++;
      }
      if(j == needle.length()) {
        return i - j + 1;
      }
    }
    return  -1;
  }

  public static  int[] kmpNext(String dest) {
    int[] next = new int[dest.length()];
    next[0] = 0;
    for(int i = 1, j = 0; i < dest.length(); i++) {

      while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
        j = next[j-1];
      }
      if(dest.charAt(i) == dest.charAt(j)) {
        j++;
      }
      next[i] = j;
    }
    return next;
  }
}
