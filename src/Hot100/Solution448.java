package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/4/24 12:21
 * @Email:284660487@qq.com
 */
public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                continue;
            }else{
                int j = nums[i] - 1;
                while (nums[j] != 0){
                    int temp = nums[j];
                    nums[j] = 0;
                    j = temp - 1;
                }
            }
        }
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                rst.add(i + 1);
            }
        }
        return rst;
    }

}
