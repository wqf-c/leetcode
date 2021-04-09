package Hot100;

/**
 * @author wqf
 * @date 2021/3/25 22:49
 * @Email:284660487@qq.com
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        for(int i = 0; i < nums.length;){
            if(nums[i] == 1){
                i++;
            } else if(nums[i] == 0){
                if(i == start){
                    i++;
                }else{
                    int temp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = temp;
                }
                start++;
            } else{
                if(i >= end){
                    break;
                }
                int temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                end--;
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        Solution75 solution75 = new Solution75();
        solution75.sortColors(new int[]{2,0,2,1,1,0});
    }

}
