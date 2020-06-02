package solution46to90;

/**
 * Author: wqf
 * Date: 2020/2/29
 * Time: 1:25
 */
public class Solution50 {

  public static void main(String[] args) {
    System.out.println(myPow(2, -2147483648));
  }
  public static double myPow(double x, int n) {
    double result = 1;
    if(x == 0) return 0;
    if(n == 0) return 1;
    boolean flag = n == -2147483648;
    if(n < 0){
      x = 1/ x;
      n = n == -2147483648 ? 2147483647 : -n;
    }
    while (n > 0){
      double r = x;
      int i = 1;
      while (true){
       // System.out.println(i);
        if(i >= 1073741824 || i *  2 > n) break;
        r = r * r;
        i *= 2;
      }
      result *= r;
      n -= i;
    }
    return result * (flag ? x : 1);
  }

  public double myPow1(double x, int n) {
    if (n == 0) { return 1; }
    if (n == 1) { return x; }
    if (n == -1) { return 1 / x; }
    double half = myPow(x, n / 2);
    double rest = myPow(x, n % 2);
    return rest * half * half;
  }
}
