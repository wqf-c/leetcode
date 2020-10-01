package Array;

/**
 * @author wqf
 * @date 2020/10/1 17:33
 * @Email:284660487@qq.com
 */
public class Solution41 {

    public int firstMissingPositive(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; ){
            if((i + 1 == nums[i]) || nums[i] <= 0) {
                i++;
            }else{
                if(nums[i] > nums.length){
                    nums[i] = -1;
                    i++;
                }else{
                    if(nums[nums[i] - 1] == nums[i]){
                        nums[i] = -1;
                        i ++;
                    }else{
                        int temp = nums[i];
                        nums[i] = nums[nums[i] - 1];
                        nums[temp - 1] = temp;
                    }

                }
            }
        }
        for(; res < nums.length; ++res){
            if(nums[res] <= 0) break;
        }
        return res + 1;
    }

    public static void main(String[] args){
        Solution41 s41 = new Solution41();
        s41.firstMissingPositive(new int[]{1, 1});
    }
}
