package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/5
 * Time: 1:04
 */
public class Solution9 {
  public static boolean isPalindrome(int x) {
//    if(x < 0 || (x % 10 == 0 && x != 0)){
//      return false;
//    }
//
//    int maxL = (x + "").length();
//    int left = 0;
//    int right = maxL - 1;
//    int r = 1;
//    for(int i = 0; i < maxL-1; ++i){
//      r = r * 10;
//    }
//    int l = 1;
//    while (right > left){
//      if((x / l) % 10 != (x / r) % 10){
//        return false;
//      }else{
//        right --;
//        left ++;
//        r /= 10;
//        l *= 10;
//      }
//    }
//    return true;
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if(x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while(x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    return x == revertedNumber || x == revertedNumber/10;

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(121));
  }
}
