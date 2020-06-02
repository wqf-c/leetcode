package solution46to90;

/**
 * Author: wqf
 * Date: 2020/4/16
 * Time: 22:58
 */
public class Solution80 {

  public int removeDuplicates(int[] nums) {
    if(nums.length < 3){
      return  nums.length;
    }
    int index = 1;
    int count = 1;
    for(int i = 2; i < nums.length; ++i){
      if(nums[i] != nums[index]) {
        index++;
        nums[index] = nums[i];
      } else if(nums[i] == nums[index] && nums[index] != nums[index - 1]){
        index++;
        nums[index] = nums[i];
      }

    }
    return index+1;
  }

  public int removeDuplicates1(int[] nums) {
    int i = 0;
    int count = 1;
    for (int j = 1; j < nums.length; j ++){
      if (nums[i] != nums[j]){
        nums[++ i] = nums[j];
        count = 1;
      }else if (count >= 2){
        continue;
      }else{
        nums[++ i] = nums[j];
        count ++;
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    Solution80 s80 = new Solution80();
    s80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
  }
}
