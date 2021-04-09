package Hot100;

/**
 * @author wqf
 * @date 2021/2/20 17:58
 * @Email:284660487@qq.com
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        return (float)(func((total + 1) / 2, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1) +
                       func((total + 2) / 2, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1)) / 2.0;
    }

    public int func(int position, int[] nums1, int num1Start, int num1End, int[] nums2, int num2Start, int num2End){
        int len1 = num1End - num1Start + 1;
        int len2 = num2End - num2Start + 1;
        if(len1 == 0) return nums2[num2Start + position - 1];
        if(len2 == 0) return nums1[num1Start + position - 1];
        if(position == 1){
            return Math.min(nums1[num1Start], nums2[num2Start]);
        }

        int i = num1Start + Math.min(len1, position / 2) - 1;
        int j = num2Start + Math.min(len2, position / 2) - 1;
        if(nums1[i] < nums2[j]){
            return func(position + num1Start - i - 1, nums1,i + 1, num1End, nums2, num2Start, num2End);
        }else{
            return func(position + num2Start - j - 1, nums1, num1Start, num1End, nums2, j + 1, num2End);
        }

    }

    public static void main(String[] args){
        Solution4 solution4 = new Solution4();
        solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

}
