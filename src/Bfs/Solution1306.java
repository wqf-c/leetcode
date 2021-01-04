package Bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/12/12 21:36
 * @Email:284660487@qq.com
 */
public class Solution1306 {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int arrLen = arr.length;
        queue.offer(start);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            int step = arr[cur];
            if(step == 0) return true;
            arr[cur] = -1;
            if(cur + step < arrLen && arr[cur + step] >= 0){
                queue.offer(cur + step);
            }
            if(cur - step >= 0 && arr[cur - step] >= 0){
                queue.offer(cur - step);
            }
        }
        return false;
    }

}
