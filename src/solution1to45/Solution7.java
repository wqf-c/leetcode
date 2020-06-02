package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/3
 * Time: 19:48
 */
public class Solution7 {

  public static void main(String[] args) {
    System.out.println(reverse(-323));
  }

  public static int reverse(int x) {
    long result = 0;
    while (x != 0){
      result = result * 10 + x % 10;
      x /= 10;
    }
    return ((int)result == result ? (int) result : 0);
  }
}
