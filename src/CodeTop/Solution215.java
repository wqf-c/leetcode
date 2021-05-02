package CodeTop;

import java.util.Arrays;

/**
 * @author wqf
 * @date 2021/5/2 20:18
 * @Email:284660487@qq.com
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
       // Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int l = left, r = right;
        int mid = (left + right) / 2;
        int temp = nums[mid];
        nums[mid] = nums[left];
        nums[left] = temp;
        while (l < r){
            while (r > l && nums[r] >= temp) r--;
            while (r > l && nums[l] <= temp) l++;
            if(l < r){
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        nums[left] = nums[l];
        nums[l] = temp;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

}
