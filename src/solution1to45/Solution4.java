package solution1to45;

/**
 * Author: wqf
 * Date: 2020/1/30
 * Time: 22:42
 */
public class Solution4 {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int left = (n + m + 1) / 2;
    int right = (n + m + 2) / 2;
    return (getMidValue(nums1, 0, n - 1, nums2, 0, m - 1, left) + getMidValue(nums1, 0, n - 1, nums2, 0, m - 1, right))/2;
  }

  public static double getMidValue(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k){
    int len1 = end1 - start1 + 1;
    int len2 = end2 - start2 + 1;
    if(len1 == 0){
      return num2[start2 + k - 1];
    }
    if(len2 == 0){
      return num1[start1 + k - 1];
    }
    if(k == 1){
      return Math.min(num1[start1], num2[start2]);
    }
    int i = start1 + Math.min(len1, k/2) - 1;
    int j = start2 + Math.min(len2, k/2) - 1;
    if(num1[i] < num2[j]){
      return getMidValue(num1, i+1, end1, num2, start2, end2, k + start1 - i - 1);
    }else{
      return getMidValue(num1, start1, end1, num2, j+1, end2, k + start2 - j - 1);
    }

  }
}
