package Hot100;

/**
 * @author wqf
 * @date 2021/4/14 21:25
 * @Email:284660487@qq.com
 */
public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null) return null;
        int[] rst = new int[nums.length];
        int cur = 1;
        for(int i = 0; i < nums.length; ++i){
            rst[i] = cur;
            cur *= nums[i];
        }
        cur = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            rst[i] = cur * rst[i];
            cur *= nums[i];
        }
        return rst;
    }

}
