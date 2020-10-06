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
        if(intervals == null || intervals.length == 1 || intervals.length == 0) return intervals;
        quickSort(0, intervals.length - 1, intervals);
        int[][] rst1 = new int[intervals.length][2];
        int index = 0;
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] <= temp[1]){
                mergeTwo(temp, intervals[i], temp);
            }else{
                List<Integer> list = new ArrayList<>();
                rst1[index][0] = temp[0];
                rst1[index][1] = temp[1];
                index++;
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(temp[0]);
        list1.add(temp[1]);
        rst1[index][0] = temp[0];
        rst1[index][1] = temp[1];
        int[][] rst = new int[index + 1][2];
        for(int i = 0; i <= index; ++i){
            rst[i][0] = rst1[i][0];
            rst[i][1] = rst1[i][1];
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
