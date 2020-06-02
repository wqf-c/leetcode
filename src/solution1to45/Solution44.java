package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/22
 * Time: 20:29
 */
public class Solution44 {

  public static void main(String[] args) {
    System.out.println(isMatch("a", "a*"));

  }
  //用递归超出时间限制，用while循环4ms...
  public static boolean isMatch(String s, String p) {
    if((s.isEmpty() && p.isEmpty()) || "*".equals(p)) return true;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < p.length(); ){
      char ch = p.charAt(i);
      if(ch != '*') {
        sb.append(ch);
        i++;
      }
      else{
        while (i < p.length() && p.charAt(i) == '*') i ++;
        sb.append('*');
      }
    }
    String newP = sb.toString();
  //  System.out.println(newP);
    int i = 0;
    int j = 0;
    int positionS = -1;
    int positionP = -1;
    while (i < s.length()){
      if (j < newP.length() && (s.charAt(i) == newP.charAt(j) || newP.charAt(j) == '?')){
        i ++;
        j ++;
        continue;
      }
      if(j < newP.length() && newP.charAt(j) == '*'){
        positionS = i;
        positionP = j;
        j ++;
        continue;
      }
      if(positionP != -1){
        j = positionP + 1;
        positionS ++;
        i = positionS;
        continue;
      }
      return false;
    }
   // System.out.println("i:" + i + " j:" + j);
    while (j < newP.length() && newP.charAt(j) == '*') j ++;
    return j == newP.length();
  }

  public boolean judge(String s, int indexS, String p, int indexP){
    if(indexS < s.length() && indexP < p.length()){
      boolean flag = false;
      while (indexP < p.length() && indexS < s.length()){
        char charP = p.charAt(indexP);
        char charS = s.charAt(indexS);
        if(charP == charS || charP == '?'){
          indexP ++;
          indexS ++;
        }else if(charP != '*'){
          return false;
        } else{
          //代表找到了"*"
          flag = true;
          break;
        }
      }
      if(!flag){
        return judge(s, indexS, p, indexP);
      }else{
        return judge(s, indexS, p, indexP + 1) || judge(s, indexS + 1, p, indexP);
      }
    }else{
      if(indexP == p.length() && indexS == s.length()){
        return true;
      }else{
        if(indexS == s.length()){
          while (indexP < p.length() && p.charAt(indexP) == '*') indexP ++;
          return indexP == p.length();
        }else{
          return false;
        }

      }
    }
  }

  //动态规划666
  public static boolean isMatch2(String s, String p){
    boolean[][] matchs = new boolean[s.length() + 1][p.length() + 1];
    matchs[0][0] = true;
    for(int i = 1; i < s.length() - 1; ++i){
      matchs[i][0] = false;
    }
    for(int i = 1; i < p.length(); ++i){
      matchs[0][i] = matchs[0][i - 1] && p.charAt(i) == '*';
    }
    for(int i = 1; i < s.length() + 1; ++i){
      for(int j = 1; j < p.length() + 1; ++j){
         if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') matchs[i][j] = matchs[i - 1][j - 1];
         else if(p.charAt(j - 1) == '*'){
           matchs[i][j] = matchs[i - 1][j] || matchs[i][j - 1];
         }
      }
    }
    return matchs[s.length()][p.length()];
  }
}
