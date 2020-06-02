package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 1:05
 */
public class Solution67 {

  public static void main(String[] args) {
    addBinary("1010", "1011");
  }
  public static String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    boolean flag = false;
    for(; i >= 0 && j >= 0; --i, --j){
      int i1 = a.charAt(i) - '0';
      int i2 = b.charAt(j) - '0';
      int add = flag ? 1 : 0;
      sb.append((i1 + i2 + add) % 2);
      System.out.println((i1 + i2 + add) % 2);
      flag = (i1 + i2 + add) >= 2;
    }
    for(; i >= 0; --i){
      int i1 = a.charAt(i) - '0';
      int add = flag ? 1 : 0;
      sb.append((i1 + add) % 2);
      flag = (i1 + add) >= 2;
    }

    for(; j >= 0; --j){
      int i1 = b.charAt(j) - '0';
      int add = flag ? 1 : 0;
      sb.append((i1 + add) % 2);
      flag = (i1 + add) >= 2;
    }
    if(flag) sb.append(1);
    return sb.reverse().toString();
  }
}
