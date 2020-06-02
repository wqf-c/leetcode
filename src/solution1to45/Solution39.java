package solution1to45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/21
 * Time: 1:32
 */
public class Solution39 {

  public static void main(String[] args) {
    combinationSum(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0}, 10);
  }
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if(candidates.length == 0) return res;
    //自己写的排序函数用Arrays.sort代替,从3ms -> 4ms ...
    quickSort(candidates, 0, candidates.length - 1);
//    Arrays.sort(candidates);
    if(target < candidates[0]) return res;
    getRes(res, new ArrayList<Integer>(), target, candidates, candidates.length - 1);
    return res;
  }

  public static void getRes(List<List<Integer>> res, List<Integer> save, int target,int[] candidates, int index){
    if(target == 0) res.add(save);
    while (index >= 0 && candidates[index] > target) index--;
    if(index == -1) return;
    int count = target / candidates[index];
    getRes(res, save, target, candidates, index -1);
    for(int i = 1; i <= count; ++i){
      List<Integer> list = new ArrayList<>(save);
      for(int j = 0; j < i; ++j) list.add(candidates[index]);
      getRes(res, list, target - i * candidates[index], candidates, index - 1);
    }
  }

  public static void quickSort(int[] num, int left, int right){
    if(left >= right) return;
    int low = left;
    int high = right;
    int p = num[left];
    int temp;
    while (low < high){
      while (num[high] >= p && high > low) high --;
      while (num[low] <= p && high > low) low ++;
      if(low < high){
        temp = num[low];
        num[low] = num[high];
        num[high] = temp;
      }
    }
    num[left] = num[low];
    num[low] = p;
    quickSort(num, left, low - 1);
    quickSort(num, low + 1, right);
  }
}
