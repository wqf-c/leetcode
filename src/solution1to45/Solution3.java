package solution1to45;

/**
 * Author: wqf
 * Date: 2020/1/29
 * Time: 23:55
 */
public class Solution3 {

  public static int lengthOfLongestSubstring(String s) {
    int max = 0;
    int k = 0;
    int count = 0;
    for(int i = 0; i < s.length(); ++i){
      for(int j = k; j < i; ++j){
        System.out.println(count);
        count++;
        if(s.charAt(i) == s.charAt(j)){
          k = j + 1;
       //   System.out.println("1k:"+k + " 1i" + i);
          break;
        }
      }
      if(i - k + 1 > max){
       // System.out.println("i:" + i);
       // System.out.println("k:" + k);
        max = i - k + 1;
     //   System.out.println(max);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int max = lengthOfLongestSubstring("abcabcbb");
    //System.out.println(max);
  }
}
