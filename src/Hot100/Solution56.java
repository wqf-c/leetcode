package Hot100;

/**
 * @author wqf
 * @date 2021/3/20 21:43
 * @Email:284660487@qq.com
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];
        quickSort(intervals, 0, intervals.length - 1);
        int[][] temp = new int[intervals.length][2];
        int index = 0;
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i){
            if(end < intervals[i][0]){
                temp[index][0] = start;
                temp[index][1] = end;
                index++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if(end >= intervals[i][0] && end <= intervals[i][1]){
                end = intervals[i][1];
            }
        }
        temp[index][0] = start;
        temp[index][1] = end;
        int[][] rst = new int[index + 1][2];
        for(int i = 0; i <= index; ++i){
            rst[i][0] = temp[i][0];
            rst[i][1] = temp[i][1];
        }
        return rst;
    }

    public void quickSort(int[][] intervals, int left, int right){
        if(left > right) return;
        int[] temp = intervals[left];
        int l = left, r = right;
        while (l < r){
            while (l < r && intervals[r][0] >= temp[0]) r--;
            while (l < r && intervals[l][0] <= temp[0]) l++;
            if(l < r){
                int[] t = intervals[l];
                intervals[l] = intervals[r];
                intervals[r] = t;
            }
        }
        intervals[left] = intervals[l];
        intervals[l] = temp;
        quickSort(intervals, left, r - 1);
        quickSort(intervals, r + 1, right);
    }

    public static void main(String[] args){
        Solution56 solution56 = new Solution56();
        solution56.merge(new int[][]{{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}});
    }

}
