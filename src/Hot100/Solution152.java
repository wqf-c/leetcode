package Hot100;

/**
 * @author wqf
 * @date 2021/4/10 11:24
 * @Email:284660487@qq.com
 */
public class Solution152 {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int prev = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                if(0 > max) max = 0;
                int n = findMax(nums, prev, i - 1);
                if(n > max) max = n;
                prev = i + 1;
            }
        }
        if(prev < nums.length){
            int n = findMax(nums, prev, nums.length - 1);
            if(n > max) max = n;
        }

        return max;
    }

    public int findMax(int[] nums, int start, int end){
        if(end <= start) return nums[start];
        int nagSize = 0;
        for(int i = start; i <= end; ++i){
            if(nums[i] < 0) nagSize ++;
        }
        if(nagSize % 2 == 0){
            int num = 1;
            for(int i = start; i <= end; ++i){
                num *= nums[i];
            }
            return num;
        }else{
            int num1 = 1, num2 = 1, size = 0;
            for(int i = start; i <= end; ++i){
                if(nums[i] < 0) size++;
                if(size <= nagSize - 1){
                    num1 *= nums[i];
                }
                if(size > 1 || (size == 1 && nums[i] > 0)){
                    num2 *= nums[i];
                }
            }
            return num1 > num2 ? num1 : num2;
        }
    }

    //先计算从左到右的相乘的最大值，再计算从右到左的最大值；再将两组最大值相比

    public static void main(String[] args){
        Solution152 solution152 = new Solution152();
        solution152.maxProduct(new int[]{0});
    }
}
