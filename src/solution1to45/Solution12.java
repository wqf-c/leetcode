package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/8
 * Time: 22:11
 */
public class Solution12 {

  public String intToRoman(int num) {
    String result = "";
    String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int k = 0;
    int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    for(int index = 0; index < numbers.length; ++index){
      k = num / numbers[index];
      num -= k * numbers[index];
      for(int j = 0; j < k; ++j) {
        result += str[index];
      }
    }
    return result;
  }

}
