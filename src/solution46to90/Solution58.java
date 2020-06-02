package solution46to90;

/**
 * Author: wqf
 * Date: 2020/3/5
 * Time: 3:26
 */
public class Solution58 {

  public int lengthOfLastWord(String s) {
    //调库函数还没有自己实现快
    String[] strs = s.trim().split(" ");
    return strs[strs.length - 1].length();
  }
}
