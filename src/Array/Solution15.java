package Array;

import java.util.*;

/**
 * @author wqf
 * @date 2020/9/27 22:58
 * @Email:284660487@qq.com
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();
        //quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length - 1] < 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 2 && nums[i] <= 0;){
            int target = 0 - nums[i];
            for(int j = nums.length - 1; j > i + 1 && nums[j] >= 0;){
                int diff = target - nums[j];
                if(binaryfind(nums, i + 1, j - 1, diff)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(diff);
                    res.add(list);
                }
                j--;
                while (j > i + 1 && nums[j] == nums[j + 1]) j--;
            }
            i++;
            while (i < nums.length - 2 && nums[i] <= 0 && nums[i] == nums[i - 1]) i++;
        }
        return res;
    }

    public boolean binaryfind(int[] nums, int start, int end, int target){
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
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
        Solution15 s15 = new Solution15();
        s15.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
