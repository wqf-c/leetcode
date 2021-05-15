package CodeTop;

/**
 * @author wqf
 * @date 2021/5/3 13:04
 * @Email:284660487@qq.com
 */
public class Solution912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int l = left, r = right;
        int mid = (left + right) / 2;
        int temp = nums[mid];
        nums[mid] = nums[l];
        nums[l] = temp;
        while (l < r){
            while (l < r && nums[r] >= temp) {
                r--;
            }
            while (l < r && nums[l] <= temp) {
                l++;
            }
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

    public static void main(String[] args) {
        Solution912 solution912 = new Solution912();
        int[] ints = solution912.sortArray(new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1});
        for (int u : ints){
            System.out.println(u);
        }
    }

}
