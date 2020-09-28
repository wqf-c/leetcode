package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author wqf
 * @date 2020/9/28 22:51
 * @Email:284660487@qq.com
 */
public class Solution31 {

    //1ms, 99.76%
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                int j = i + 1;
                for(; j < nums.length; ++j){
                    if(nums[j] <= nums[i]){
                        break;
                    }
                }
                j = j - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
               // quickSort(nums, i + 1, nums.length - 1);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public void reverse(int[] nums, int left, int end){
        int temp;
        while (left < end){
            temp = nums[left];
            nums[left] = nums[end];
            nums[end] = temp;
            left++;
            end--;
        }
    }

    public void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int l = left, r = right;
        int pro = nums[left];
        while (l < r){
            while (r > l && nums[r] >= pro) r--;
            while (r > l && nums[l] <= pro) l++;
            if(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[l];
        nums[l] = pro;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    public static void main(String[] args){
        Solution31 s31 = new Solution31();
        s31.nextPermutation(new int[]{1, 5, 1});
    }
}
