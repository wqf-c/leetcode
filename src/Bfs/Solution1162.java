package Bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/12/10 22:18
 * @Email:284660487@qq.com
 */
public class Solution1162 {

    public int maxDistance(int[][] grid) {
        int rst = -1;
        Queue<int[]> queue = new LinkedList<>();
        for(int y = 0; y < grid.length; ++y){
            for(int x = 0; x < grid[0].length; ++x){
                if(grid[y][x] != 0){
                    queue.offer(new int[]{y, x});
                }
            }
        }
        if(queue.isEmpty() || queue.size() == grid.length * grid[0].length) return -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int[] cur = queue.poll();
                int y = cur[0], x = cur[1];
                int num = grid[y][x];
                if(y - 1 >= 0 && grid[y - 1][x] == 0){
                    grid[y - 1][x] = num + 1;
                    if(num + 1 > rst) rst = num + 1;
                    queue.offer(new int[]{y - 1, x});
                }
                if(y + 1 < grid.length && grid[y + 1][x] == 0){
                    grid[y + 1][x] = num + 1;
                    if(num + 1 > rst) rst = num + 1;
                    queue.offer(new int[]{y + 1, x});
                }
                if(x - 1 >= 0 && grid[y][x - 1] == 0){
                    grid[y][x - 1] = num + 1;
                    if(num + 1 > rst) rst = num + 1;
                    queue.offer(new int[]{y, x - 1});
                }
                if(x + 1 < grid[0].length && grid[y][x + 1] == 0){
                    grid[y][x + 1] = num + 1;
                    if(num + 1 > rst) rst = num + 1;
                    queue.offer(new int[]{y, x + 1});
                }
            }
        }
        return rst - 1;
    }



    public static void main(String[] args){
        Solution1162 solution1162 = new Solution1162();
        System.out.println(solution1162.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));

    }

}
