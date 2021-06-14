package CodeTop;

/**
 * @author wqf
 * @date 2021/6/8 0:19
 * @Email:284660487@qq.com
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        int curNum = nums[0], curN = 1;
        for(int i = 1; i < nums.length;){
            if(nums[i] == curNum){
                curN++;
            }else{
                curN--;
                if(curN == 0){
                    curNum = nums[i + 1];
                    curN = 1;
                    i++;
                }
            }
            i++;
        }
        return curNum;
    }

}
