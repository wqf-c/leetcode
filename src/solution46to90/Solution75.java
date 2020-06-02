package solution46to90;

/**
 * Author: wqf
 * Date: 2020/4/13
 * Time: 18:47
 */
public class Solution75 {

  public void sortColors(int[] nums) {
    int size = nums.length;
    int zIndex = 0;
    int oIndex = 0;
    int tIndex = size - 1;
    for(int i = 0; i <= tIndex; ++i){
      switch (nums[i]){
        case 0:
          nums[zIndex] = 0;
          zIndex ++;
          break;
        case 1:
          oIndex ++;
          break;
        case 2:
            while (tIndex >= i && nums[tIndex] == 2){
              tIndex--;
            }
            if(tIndex == i - 1){
              break;
            }
            if(nums[tIndex] == 0){
              nums[zIndex] = 0;
              zIndex ++;
            }else{
              oIndex ++;
            }
            nums[tIndex] = 2;
            tIndex --;

          break;
        default:
          break;
      }
    }
    for(int i = 0; i < oIndex; ++i){
      nums[zIndex + i] = 1;
    }
  }

  //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，
  // 而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++。
  public void sortColors1(int[] nums) {
    // 对于所有 idx < i : nums[idx < i] = 0
    // j是当前考虑元素的下标
    int p0 = 0, curr = 0;
    // 对于所有 idx > k : nums[idx > k] = 2
    int p2 = nums.length - 1;

    int tmp;
    while (curr <= p2) {
      if (nums[curr] == 0) {
        // 交换第 p0个和第curr个元素
        // i++，j++
        tmp = nums[p0];
        nums[p0++] = nums[curr];
        nums[curr++] = tmp;
      }
      else if (nums[curr] == 2) {
        // 交换第k个和第curr个元素
        // p2--
        tmp = nums[curr];
        nums[curr] = nums[p2];
        nums[p2--] = tmp;
      }
      else curr++;
    }
  }


}
