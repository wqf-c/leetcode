package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 23:11
 */
public class Solution72 {

  public static void main(String[] args) {
    minDistance("horse", "ros");
  }
  //动态规划 666
  public static int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    if(len1*len2==0) return len1+len2;
    int[][] bp = new int[len1+1][len2+1];
    bp[0][0] = 0;
    for(int i = 1; i < len1+1; ++i){
      bp[i][0] = i;
    }
    for(int i = 1; i < len2+1; ++i){
      bp[0][i] = i;
    }
    for(int i = 1; i < len1+1; ++i){
      for(int j = 1; j < len2+1; ++j){
        int option1 = bp[i - 1][j] + 1;
        int option2 = bp[i][j - 1] + 1;
        int option3 = bp[i - 1][j - 1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
        bp[i][j] = Math.min(option1, Math.min(option2, option3));
      }
    }
    return bp[len1][len2];
  }
}
