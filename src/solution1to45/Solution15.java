package solution1to45;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/12
 * Time: 21:08
 */
public class Solution15 {

  public static void main(String[] args) {
    int[] nums = new int[]{-1,0,1,2,-1,-4};
    List<List<Integer>> lists = threeSum(nums);
    for(List<Integer> l : lists){
      for(Integer e: l){
        System.out.println(e);
      }
    }
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums == null || nums.length < 3){
      return result;
    }

    Arrays.sort(nums);
    for(int i : nums) System.out.print(i + "  ");
    System.out.println();
    if(nums[0] > 0 || nums[nums.length - 1] < 0) return result;
    for(int i = 0; i < nums.length && nums[i] <= 0;){
      for(int j = nums.length - 1; nums[j] >= 0 && j > i + 1;){
        int xiabiao = binarySearch(nums, i+1, j-1, 0 - (nums[i] + nums[j]));
        if(xiabiao != -1){
          List<Integer> l = new ArrayList<Integer>();
          l.add(nums[i]);
          l.add(nums[j]);
          l.add(nums[xiabiao]);
          result.add(l);
        }
        int temp = nums[j];
        while (j > i + 1 && temp == nums[j]){
          j --;
        }
      }
      int temp = nums[i];
      while (i < nums.length && nums[i] == temp){
        i ++;
      }
    }
    return result;
  }

  public static int binarySearch(int nums[], int left, int right, int find){
    int mid;
    while (left <= right){
      mid = (left + right) / 2;
      if(nums[mid] == find) return mid;
      if(nums[mid] > find) right = mid - 1;
      else left = mid + 1;
//      if(find == 1) System.out.print(mid + " ");
    }
//    System.out.println();
    return -1;

  }

  public static void quickSort(int[]arr, int left, int right){
    if(left >= right){
      return;
    }
    int low = left;
    int high = right;
    int pority = arr[left];
    int temp = 0;
    while (low < high){
      while (arr[high] >= pority && high > low){
        high --;
      }
      while (arr[low] <= pority && high > low){
        low ++;
      }
      if(low < high){
        temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
      }
    }

    arr[left] = arr[low];
    arr[low] = pority;
    quickSort(arr, left, low - 1);
    quickSort(arr, low + 1, right);
  }
}
