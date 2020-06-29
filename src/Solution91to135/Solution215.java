package Solution91to135;

import java.util.Random;

public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    void quickSort(int[] nums, int low, int high){
        int temp, left = low, right = high;

        if(low < high){
            int rand = new Random().nextInt(high - low + 1) + low;
            temp = nums[rand];
            while (low < high){
                while (low < high && nums[high] > temp){
                    high --;
                }
                while (low < high && nums[low] <= temp){
                    low ++;
                }
                if(low < high){
                    int tem = nums[low];
                    nums[low] = nums[high];
                    nums[high] = tem;
                    if(low == rand || high == rand)
                        rand = low == rand ? high : low;
                }
            }
            int k=nums[rand];
            nums[rand]=nums[low];
            nums[low]=k;
            quickSort(nums, left, low - 1);
            quickSort(nums, low + 1, right);
        }
    }

    public static void main(String[] args){
        Solution215 s = new Solution215();
        s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 4);
    }

}
