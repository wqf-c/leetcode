package Bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * @author wqf
 * @date 2020/12/12 21:48
 * @Email:284660487@qq.com
 */
public class Solution1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int rightBinary = 8050;
        //value  0 未经过  1 向前跳跃过 2 前后都跳跃过
        int[] map = new int[8050];
        int step = 0;
        for(int forb : forbidden){
            map[forb] = 2;
        }

        Queue<Pair<Integer, Boolean>> queue = new LinkedList<>();
        //value 上一个节点是向前跳（false）还是向后跳（true）
        queue.offer(new Pair<>(0, false));
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                Pair<Integer, Boolean> pair = queue.poll();
                int key = pair.getKey();
                boolean value = pair.getValue();
                if(key == x) return step;
                if(map[key] != 0){
                    int type = map[key];
                    if(type == 2) continue;
                    //向前跳跃过
                    if(type == 1){
                        //上一个节点是向前跳
                        if(!value){
                            //可以向后跳
                            map[key] = 2;
                            if(key - b >= 0) queue.offer(new Pair<>(key - b, true));
                        }
                    }
                }else{
                    if(!value){
                        map[key] = 2;
                        if(key + a < rightBinary){
                            queue.offer(new Pair<>(key + a, false));
                        }
                        if(key - b >= 0){
                            queue.offer(new Pair<>(key - b, true));
                        }
                    }else{
                        map[key] = 1;
                        if(key + a < rightBinary){
                            queue.offer(new Pair<>(key + a, false));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution1654 solution1654 = new Solution1654();
        solution1654.minimumJumps(new int[]{14,4,18,1,15}, 3, 15, 9);
    }

}
