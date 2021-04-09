package Hot100;

/**
 * @author wqf
 * @date 2021/4/6 22:44
 * @Email:284660487@qq.com
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length; ++i){
            x = x ^ nums[i];
        }
        return x;
    }

}
