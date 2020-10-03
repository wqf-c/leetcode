package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wqf
 * @date 2020/10/3 21:34
 * @Email:284660487@qq.com
 */
public class Solution56 {
//    执行用时：
//            3 ms
//, 在所有 Java 提交中击败了
//97.48%
//    的用户
//    内存消耗：
//            41 MB
//, 在所有 Java 提交中击败了
//97.53%
//    的用户
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 1) return intervals;
        quickSort(0, intervals.length - 1, intervals);
        List<List<Integer>> lists = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] <= temp[1]){
                mergeTwo(temp, intervals[i], temp);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(list);
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(temp[0]);
        list1.add(temp[1]);
        lists.add(list1);
        int[][] rst = new int[lists.size()][2];
        for(int i = 0; i < lists.size(); ++i){
            rst[i][0] = lists.get(i).get(0);
            rst[i][1] = lists.get(i).get(1);
        }
        return rst;
    }

    public static void mergeTwo(int[] a, int[] b, int[] c){
        c[0] = Math.min(a[0], b[0]);
        c[1] = Math.max(a[1], b[1]);
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

    public static void main(String[] args){
        int[][] interval = {{1,4},{4,5}};
        merge(interval);
    }
}
