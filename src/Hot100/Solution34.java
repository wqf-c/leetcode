package Hot100;

/**
 * @author wqf
 * @date 2021/3/15 16:26
 * @Email:284660487@qq.com
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] rst = new int[2];
        rst[0] = -1;
        rst[1] = -1;
        binarySearch(nums, 0, nums.length - 1, target, rst, 0);
        binarySearch(nums, 0, nums.length - 1, target, rst, 1);
        return rst;
    }

    public void binarySearch(int[] nums, int left, int right, int target, int[] rst, int rstIndex){
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                if(rst[0] > mid || rst[0] == -1) rst[0] = mid;
                if(rst[1] < mid || rst[1] == -1) rst[1] = mid;
                if(rstIndex == 0){
                    binarySearch(nums, left, mid - 1, target, rst, 0);
                    return;
                }else{
                    binarySearch(nums, mid + 1, right, target, rst, 1);
                    return;
                }
            }
            if(nums[mid] < target) left = mid + 1;
            if(nums[mid] > target) right = mid - 1;
        }
    }

    public static void main(String[] args){
        Solution34 solution34 = new Solution34();
        int[] rst = solution34.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(rst[0] + "  " + rst[1]);
    }


}
