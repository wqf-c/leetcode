package Hot100;

/**
 * @author wqf
 * @date 2021/4/11 12:06
 * @Email:284660487@qq.com
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        int curNum = nums[0];
        int curNumSize = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == curNum){
                curNumSize++;
            }else{
                curNumSize--;
                if(curNumSize == 0){
                    if(i + 1 < nums.length){
                        curNum = nums[i + 1];
                        curNumSize = 1;
                        i++;
                    }
                }
            }
        }
        return curNum;
    }

}
