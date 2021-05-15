package CodeTop;

/**
 * @author wqf
 * @date 2021/5/10 23:53
 * @Email:284660487@qq.com
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1, nums2Index = n - 1, rstIndex = (m + n - 1);
        for(; nums1Index >= 0 && nums2Index >= 0;){
            if(nums1[nums1Index] > nums2[nums2Index]){
                nums1[rstIndex] = nums1[nums1Index];
                nums1Index--;
            }else{
                nums1[rstIndex] = nums2[nums2Index];
                nums2Index--;
            }
            rstIndex--;
        }
        if(nums1Index >= 0){
            for(;rstIndex >= 0; --rstIndex){
                nums1[rstIndex] = nums1[nums1Index];
                nums1Index--;
            }
        }
        if(nums2Index >= 0){
            for(;rstIndex >= 0; --rstIndex){
                nums1[rstIndex] = nums2[nums2Index];
                nums2Index--;
            }
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        solution88.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

}
