package Hot100;

/**
 * @author wqf
 * @date 2021/4/17 12:08
 * @Email:284660487@qq.com
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        int zSize = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0) {
                zSize++;
                continue;
            }
            nums[i - zSize] = nums[i];
        }
        for(int i = nums.length - 1; i >= nums.length - zSize; --i){
            nums[i] = 0;
        }
    }

}
