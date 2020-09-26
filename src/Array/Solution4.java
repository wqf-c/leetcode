package Array;

/**
 * @author wqf
 * @date 2020/9/21 21:35
 * @Email:284660487@qq.com
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        return (find(nums1, 0, n - 1, nums2, 0, m - 1, (m + n + 1) / 2) +
                find(nums1, 0, n - 1, nums2, 0, m - 1, (m + n + 2) / 2)) / 2;
    }

    public double find(int[]nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 == 0) return nums2[start2 + k - 1];
        if(len2 == 0) return nums1[start1 + k - 1];
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2);
        int j = start2 + Math.min(len2, k / 2);
        if(nums1[i - 1] < nums2[j - 1]){
            return find(nums1, i, end1, nums2, start2, end2, k - Math.min(len1, k / 2));
        }else{
            return find(nums1, start1, end1, nums2, j, end2, k - Math.min(len2, k / 2));
        }
    }
}
