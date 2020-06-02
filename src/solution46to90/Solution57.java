package solution46to90;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Author: wqf
 * Date: 2020/3/5
 * Time: 1:04
 */
public class Solution57 {

//  [[1,2],[3,5],[6,7],[8,10],[12,16]]
//    [4,8]

  //做复杂了，可以先将newInterval左边的添加，再添加newInterval,在添加合并右边的
  public static void main(String[] args) {
    int[][] res = insert(new int[][]{{1,5},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8});
    for(int i = 0; i < res.length; ++i){
      System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
    }
  }
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    if(intervals.length == 0){
      int[][] res = new int[1][2];
      res[0] = newInterval;
      return res;
    }
    int[][] result = new int[intervals.length + 1][2];
    int count = 0;
    boolean flag = false;
    if(newInterval[1] < intervals[0][0]){
      result[count] = newInterval;
      count++;
      flag = true;
    }
    int i = 0;
    if((intervals[0][0] >= newInterval[0] && intervals[0][0] <= newInterval[1]) ||
      (intervals[0][1] >= newInterval[0] && intervals[0][1] <= newInterval[1])){
      result[0][0] = Math.min(intervals[0][0], newInterval[0]);
      result[0][1] = Math.max(intervals[0][1], newInterval[1]);
      i = 1;
      count = 1;
    }
    for(; i < intervals.length; ++i){
      result[count] = intervals[i];
      count++;
      if(!flag){
        if(count - 2 >= 0 && result[count-2][1] > intervals[i][1]) {
          count--;
          continue;
        }
        if(newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]){
          if(newInterval[1] <= result[count - 1][1]) {
            flag = true;
          }
          int max = Math.max(result[count - 1][1], newInterval[1]);
          result[count - 1][1] = max;

        }else if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]){
            count--;
            result[count - 1][1] = intervals[i][1];
          flag = true;
        }else{
          if(newInterval[0] > intervals[i][1] && (i == intervals.length - 1 || newInterval[0] < intervals[i + 1][0])){
            result[count] = newInterval;
            count++;
          }
          if(intervals[i][0] > newInterval[1]) {
            flag = true;
          }
        }
      }
    }
    int[][] res = new int[count][2];
    for(int j = 0; j < count; ++j){
      res[j][0] = result[j][0];
      res[j][1] = result[j][1];
    }
    return res;
  }

}
