package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 20:46
 */
public class Solution69 {

  public static void main(String[] args) {
    System.out.println(mySqrt(2147483647));
  }

  //x(n+1)=[x(n)+a/x(n)]/2
  public static int mySqrt(int x) {
    if(x == 0) return 0;
    long result = 1;
    while (true){
      if(result * result <= x && (result + 1)*(result + 1) > x) break;

      result = (result + x / result) / 2;
    }
    return (int)result;
  }

}
