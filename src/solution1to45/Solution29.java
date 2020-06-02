package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/18
 * Time: 18:11
 */
public class Solution29 {


  public static void main(String[] args) {
    System.out.println(divide(-2147483648, -3));
  }
  public static int divide(int dividend, int divisor) {
    if(dividend == Integer.MIN_VALUE && divisor == -1){
      return Integer.MAX_VALUE;
    }else if(dividend == Integer.MIN_VALUE && divisor == 1){
      return Integer.MIN_VALUE;
    }else if(divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) return 1;
    else if(divisor == Integer.MIN_VALUE) return 0;

    if(dividend == 0) return 0;
    int singnature = -1;
    if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) singnature = -1;
    else singnature = 1;
    divisor = Math.abs(divisor);
    if(dividend == Integer.MIN_VALUE){
      int add = 0;
      int k = getNumber(Integer.MAX_VALUE, divisor, divisor, 1);
      if(1 + (Integer.MAX_VALUE - k * divisor) >= divisor) add = 1;
      return (add + k) * singnature;
    }
    dividend = Math.abs(dividend);

    if(dividend < divisor) return 0;
    return getNumber(dividend, divisor, divisor, 1) * singnature;
  }

  static int getNumber(int dividend, int divisor, int origin, int step){
    // System.out.println("dividend:" + dividend + " divisor:" + divisor + " origin:"  + origin +" step:" + step);
    if(dividend - divisor < origin && dividend - divisor >= 0) {
      //   System.out.println("1");
      return step;
    }
    else if(dividend > divisor && divisor > 0){
      //  System.out.println("2");
      return getNumber(dividend, divisor << 1, origin, step << 1);
    }else{
      //   System.out.println("3");
      //   if(divisor < 0){
      //    System.out.println((step >> 1) & 0x7fffffff);
      //  System.out.println((divisor >> 1) & 0x7fffffff);
      return ((step >> 1) & 0x7fffffff) + getNumber(dividend - ((divisor >> 1) & 0x7fffffff), origin, origin, 1);
//      }else{
//        return step >> 1 + getNumber(dividend - (divisor >> 1), origin, origin, 1);
//      }

    }
  }
}
