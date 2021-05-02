package Hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wqf
 * @date 2021/4/14 22:05
 * @Email:284660487@qq.com
 */
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] rst = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; ++i){
            if(queue.isEmpty()){
                queue.add(i);
            }else{
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                    queue.pollLast();
                }
                queue.addLast(i);
            }
            if(i - k + 1 >= 0){
                rst[i - k + 1] = nums[queue.peek()];
            }
            if(queue.peek() == i - k + 1){
                queue.poll();
            }
        }
        return rst;
    }

    public static void main(String[] args){
        Solution239 solution239 = new Solution239();
        solution239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

}
