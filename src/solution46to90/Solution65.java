package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/11
 * Time: 23:22
 */
public class Solution65 {

  //。。。垃圾题目 不做了
  public boolean isNumber(String s) {
    if(s == null || s.length() == 0 ) return false;
    s = s.trim();
    if(s.length() == 0) return false;
    boolean eFlag = false;
    boolean dotFLag = false;
    for(int i = 0; i < s.length(); ++i){
      char ch = s.charAt(i);
      if(ch == '-' || ch == '+'){
        if((i == 0 || s.charAt(i - 1) == 'e') && i != s.length() - 1) continue;
        else return false;
      }else if(ch == 'e'){
        if(!eFlag) {
          eFlag = true;
          if(i == 0 || i == s.length() - 1){
            return false;
          }
        }
        else return false;
      }else if(ch >= '0' && ch <= '9'){
      }else if(ch == '.'){
        if(!dotFLag &&  s.length() >= 2 &&
          ((i == 0  && s.charAt(1) >= '0' && s.charAt(1) <= '9') ||
            (i > 0 && i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))){
          dotFLag = true;
        }else{
          return false;
        }
      }else{
        return false;
      }
    }
    return true;
  }
}
