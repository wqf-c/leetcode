package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 0:53
 */
public class Solution66 {

  public int[] plusOne(int[] digits) {
    boolean nineFlag = false;
    int len = digits.length;
    for(int i = 0; i < len; ++i){
      if(digits[i] != 9){
        nineFlag = true;
        break;
      }
    }
    int[] result = new int[(nineFlag ? len : len + 1)];
    if(!nineFlag){
      result[0] = 1;
      return result;
    }
    boolean flag = false;
    result[len - 1] = (digits[len - 1] + 1) % 10;
    flag = digits[len - 1] == 9;
    for(int i = len - 2; i >= 0; --i){
      int add = flag ? 1 : 0;
      result[i] = (add + digits[i]) % 10;
      flag = (add + digits[i] == 10);
    }
    return result;
  }
}
