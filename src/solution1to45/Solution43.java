package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/22
 * Time: 18:03
 */
public class Solution43 {

  public String multiply(String num1, String num2) {
    int n1 = num1.length() - 1;
    int n2 = num2.length() - 1;
    if (n1 < 0 || n2 < 0) return "0";
    int[] save = new int[n1 + n2 + 2];
    char[] num1Chars = num1.toCharArray();
    char[] num2Chars = num2.toCharArray();
    for (int i = n1; i >= 0; i--) {
      for (int j = n2; j >= 0; j--) {
        int n = (num1Chars[i] - '0') * (num2Chars[j] - '0');
        n += save[i + j + 1];
        save[i + j] += n / 10;
        save[i + j + 1] = n % 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (index < save.length && save[index] == 0) index ++;
    for(;index < save.length; ++index){
      sb.append(save[index]);
    }
    if(sb.length() == 0) return "0";
    return sb.toString();
  }
}
