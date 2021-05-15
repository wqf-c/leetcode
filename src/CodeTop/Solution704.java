package CodeTop;

/**
 * @author wqf
 * @date 2021/5/12 21:36
 * @Email:284660487@qq.com
 */
public class Solution704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]) return mid;
            if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

}
