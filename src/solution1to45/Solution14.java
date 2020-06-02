package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/12
 * Time: 20:35
 */
public class Solution14 {

  public static void main(String[] args) {
    System.out.println("1".substring(0, 0));
    Solution14 s = new Solution14();
    String[] st = new String[]{"", ""};
    s.longestCommonPrefix(st);
  }

  public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";
    if(strs.length == 1) return strs[0];
    strs[0].length();
    int index = 0;
    for(int i = 0; i < strs[0].length(); ++i){
      char ch = strs[0].charAt(i);
      for(int j = 1; j < strs.length; ++j){
        if(strs[j].length() <= i || strs[j].charAt(i) != ch){
          return strs[0].substring(0, i);
        }
      }
      index = i;

    }
    System.out.println(index);
    return strs[0].substring(0, index + 1);
  }

  //分治算法
  public String longestCommonPrefix1(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    return longestCommonPrefix(strs, 0 , strs.length - 1);
  }

  private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
      return strs[l];
    }
    else {
      int mid = (l + r)/2;
      String lcpLeft =   longestCommonPrefix(strs, l , mid);
      String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
      if ( left.charAt(i) != right.charAt(i) )
        return left.substring(0, i);
    }
    return left.substring(0, min);
  }

  //二分查找法
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0)
      return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
      minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
      int middle = (low + high) / 2;
      if (isCommonPrefix(strs, middle))
        low = middle + 1;
      else
        high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
  }

  private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
      if (!strs[i].startsWith(str1))
        return false;
    return true;
  }


}
