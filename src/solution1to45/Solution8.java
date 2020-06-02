package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/5
 * Time: 0:17
 */
public class Solution8 {

  public static int myAtoi(String str) {
    long result = 0;
    int index = 0;
    char ch;
    if(str.isEmpty()){
      return 0;
    }
    for(; index < str.length(); ++index){
      if(str.charAt(index) != ' '){
        break;
      }
    }

    if(index == str.length())
      return 0;
    ch = str.charAt(index);
    if(!(ch == '-' || (ch >= '0' && ch <= '9') || ch == '+') || ((ch == '-' || ch == '+') && (index == str.length()-1 || !(str.charAt(index + 1) >= '0' && str.charAt(index + 1) <= '9')))){
      return 0;
    }
    int i = (ch == '-' || ch == '+') ? index + 1 : index;
    for(; i < str.length(); ++i){
      char c = str.charAt(i);
      if(c > '9' || c < '0'){
        break;
      }else{
        result = result * 10 + c - '0';
        if((int) result != result){
          return ch == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
      }
    }
    result = ch == '-' ? result*(-1) : result;
    return (int) result == result ? (int) result : (ch == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE);
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("18446744073709551617"));
  }

}
