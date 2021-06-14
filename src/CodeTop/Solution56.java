package CodeTop;

/**
 * @author wqf
 * @date 2021/6/7 23:34
 * @Email:284660487@qq.com
 */
public class Solution56 {

    void sort(int[][] array, int left, int right){
        if(left >= right) return;
        int l = left, r = right;
        int mid = (left + right) / 2;
        int[] temp = array[mid];
        array[mid] = array[left];
        array[left] = temp;
        while (l < r){
            while (r > l && temp[0] <= array[r][0]) r--;
            while (l < r && temp[0] >= array[l][0]) l++;
            if(l < r){
                int[] t = array[l];
                array[l] = array[r];
                array[r] = t;
            }
        }
        array[left] = array[l];
        array[l] = temp;
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }

    public int[][] merge(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];
        if(intervals.length == 0 || intervals.length == 1){
            return intervals;
        }
        int index = 0;
        sort(intervals, 0, intervals.length - 1);
        int right = intervals[0][1], left = intervals[0][0];
        for(int i = 1; i < intervals.length; ++i){
            if(right >= intervals[i][0]){
                right = Math.max(right, intervals[i][1]);
            }else {
                temp[index][0] = left;
                temp[index][1] = right;
                index++;
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        temp[index][0] = left;
        temp[index][1] = right;
        int[][] rst = new int[index + 1][2];
        for(int i = 0; i <= index; ++i){
            rst[i][0] = temp[i][0];
            rst[i][1] = temp[i][1];
        }
        return rst;
    }

}
