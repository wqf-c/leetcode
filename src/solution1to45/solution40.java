package solution1to45;

import java.util.*;

/**
 * Author: wqf
 * Date: 2020/2/21
 * Time: 18:07
 */
public class solution40 {

  private List<List<Integer>> result;
  private Stack<Integer> stack;
  private int[] candidates;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    this.result = new ArrayList<>();
    if(candidates.length == 0) return result;
    this.stack = new Stack<>();
    this.candidates = candidates;
    quickSort(candidates, 0, candidates.length - 1);
    if(target < candidates[0]) return this.result;
    dfs(0, target);
    return result;
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


  public void dfs(int index, int target){
    if(target == 0){
      result.add(new ArrayList<>(stack));
    }
    if(target < 0) return;
    for(int i = index; i < candidates.length && target >= candidates[i]; ){
      stack.add(candidates[i]);
      dfs(i + 1, target - candidates[i]);
      stack.pop();
      int j = i + 1;
      //去重
      while (j < candidates.length && candidates[j] == candidates[i]) j ++;
      i = j;
    }
  }


}
