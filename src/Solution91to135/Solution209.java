package Solution91to135;

public class Solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; ++i){
            int num = 0;
            for(int j = i; j < nums.length; ++j){
                num += nums[j];
                if(num >= s){
                    int temp = j - i + 1;
                    if(temp < min) min = temp;
                    if(min == 1) return min;
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //滑动窗口
    public int minSubArrayLen1(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int currentNum = 0;
        for(; left < nums.length && right <= nums.length;){
            if(currentNum >= s){
                if(right - left < min){
                    min = right - left;
                    if(min == 1) return min;
                }
                currentNum -= nums[left];
                left ++;
            }else{
                if(right == nums.length) break;
                currentNum += nums[right];
                right ++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args){
        Solution209 s = new Solution209();
        System.out.println(s.minSubArrayLen1(7, new int[]{2,3,1,2,4,3}));
    }
}
