package Solution91to135;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution378 {

    //二分查找法
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right){
            int mid = left + (left - right) / 2;
            if(check(matrix, mid, k, n)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n){
        int i = n - 1, j = 0;
        int num = 0;
        while (i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                j++;
                num += (i + 1);
            }else{
                i --;
            }
        }
        return num >= k;
    }

    //归并排序？？？为什么是归并排序
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        for(int i = 0; i < n; ++i){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

}
