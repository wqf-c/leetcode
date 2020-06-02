package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/19
 * Time: 16:44
 */
public class Solution33 {

  public static void main(String[] args) {
    System.out.print(search(new int[]{4,5,6,7,0,1,2}, 3));
  }

  //另一种思路，mid位置的数大于left位置的数，代表左半边是有序的，否则右半边是有序的，这种做法可以不用递归，会更快
  public static int search(int[] nums, int target) {
    if(nums.length == 0) return -1;
    int result = binarySearch(nums, 0, nums.length - 1, target);
    return result;
  }

  public static int binarySearch(int[] nums, int left, int right, int target){
    System.out.println("left:" + left + " right:" + right);
    int mid = (left + right) / 2;
    if(nums[mid] == target) return mid;
    if(left >= right) return -1;
    if(nums[left] < nums[right]){
      if(nums[mid] < target){
        return binarySearch(nums, mid + 1, right, target);
      }else{
        return binarySearch(nums, left, mid, target);
      }
    }else{
      int res = binarySearch(nums, mid + 1, right, target);
      if(res != -1) return res;
      else return binarySearch(nums, left, mid, target);
    }
  }
}
