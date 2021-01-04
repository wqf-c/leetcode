package Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/12/12 11:20
 * @Email:284660487@qq.com
 */
public class Solution967 {

    public int[] numsSameConsecDiff(int n, int k) {
        int[] rst = null;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        for(int i = 1; i < n; ++i){
            int size = queue.size();
            for(int j = 0; j < size; ++j){
                int cur = queue.poll();
                int lastNum = cur % 10;
                if(lastNum - k >= 0){
                    int next = cur * 10 + lastNum - k;
                    queue.offer(next);
                }
                if(lastNum + k <= 9 && k != 0){
                    int next = cur * 10 + lastNum + k;
                    queue.offer(next);
                }
            }
        }
        rst = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()){
            rst[i] = queue.poll();
            i++;
        }

        return rst;
    }

    public static void main(String[] args){
        Solution967 solution967 = new Solution967();
        solution967.numsSameConsecDiff(2, 0);
    }



}
