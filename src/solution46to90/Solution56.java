package solution46to90;

import javafx.scene.control.PasswordField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/3/4
 * Time: 2:02
 */
public class Solution56 {

  public static void main(String[] args) {
    //[[1,3],[2,6],[8,10],[15,18]]
    int[][] res = merge1(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    for(int i = 0; i < res.length; ++i){
      System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
    }
  }
  public static int[][] merge1(int[][] intervals) {
    List<List<Integer>> lists = new ArrayList<>();
    if(intervals.length == 0) return intervals;
    for(int i = 0; i < intervals.length; ++i){
     List<Integer> list = new ArrayList<>();
      Collections.addAll(list, intervals[i][0], intervals[i][1]);
      lists.add(list);
    }
    Collections.sort(lists, new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(0) - o2.get(0);
      }
    });
    quickSort1(0, lists.size() - 1, lists);
//    for(int i = 0; i < lists.size(); ++i){
//      System.out.println("[" + lists.get(i).get(0) + ", " + lists.get(i).get(1) + "]");
//    }
    List<List<Integer>> result = new ArrayList<>();
    result.add(lists.get(0));
    for(int i = 1; i < lists.size(); ++i){
      int len = result.size()- 1;
      int num = result.get(len).get(1);
      if(lists.get(i).get(0) <= num){
        result.get(len).set(1, Math.max(lists.get(i).get(1), num));
      }else{
        result.add(lists.get(i));
      }
    }
    int[][] res = new int[result.size()][2];
    for(int i = 0; i < result.size(); ++i){
      res[i][0] = result.get(i).get(0);
      res[i][1] = result.get(i).get(1);
    }
    return res;
  }

  public static void quickSort1(int left, int right, List<List<Integer>> lists){
    if(left >= right) return;
    int low = left;
    int high = right;
    List<Integer> pority = lists.get(left);
    List<Integer> temp = null;
    while (low < high){
      while (lists.get(high).get(0) >= pority.get(0) && high > low){
        high --;
      }
      while (lists.get(low).get(0) <= pority.get(0) && high > low){
        low ++;
      }
      if(low < high){
//        System.out.println("low < high");
        temp = lists.get(low);
        lists.set(low, lists.get(high));
        lists.set(high, temp);
      }
    }
//    System.out.println("left:" + left + "  low" + low);
    lists.set(left, lists.get(low));
    lists.set(low, pority);
    quickSort1(left, low - 1, lists);
    quickSort1(low + 1, right, lists);
  }

  public static int[][] merge(int[][] intervals) {

    if(intervals.length == 0) return intervals;

    quickSort(0, intervals.length - 1, intervals);
//    for(int i = 0; i < lists.size(); ++i){
//      System.out.println("[" + lists.get(i).get(0) + ", " + lists.get(i).get(1) + "]");
//    }
    int count = 0;
    int[][] result = new int[intervals.length][2];
    result[0] = intervals[0];
    count ++;
    for(int i = 1; i < intervals.length; ++i){
      int len = count- 1;
      int num = result[len][1];
      if(intervals[i][0] <= num){
        result[len][1] = Math.max(intervals[i][1], num);
      }else{
        result[count] = intervals[i];
        count ++;
      }
    }
    int[][] res = new int[count][2];
    for(int i = 0; i < count; ++i){
      res[i] = result[i];
    }
    return res;
  }

  public static void quickSort(int left, int right, int[][] lists){
    if(left >= right) return;
    int low = left;
    int high = right;
    int[] pority = lists[left];
    int[] temp = null;
    while (low < high){
      while (lists[high][0] >= pority[0] && high > low){
        high --;
      }
      while (lists[low][0] <= pority[0] && high > low){
        low ++;
      }
      if(low < high){
//        System.out.println("low < high");
        temp = lists[low];
        lists[low] = lists[high];
        lists[high] = temp;
      }
    }
//    System.out.println("left:" + left + "  low" + low);
    lists[left] = lists[low];
    lists[low] = pority;
    quickSort(left, low - 1, lists);
    quickSort(low + 1, right, lists);
  }
}
