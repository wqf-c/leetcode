package Hot100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wqf
 * @date 2021/4/24 1:20
 * @Email:284660487@qq.com
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        int[][] temp = new int[nums.length][2];
        int invalidSize = 0;
        temp[invalidSize][0] = nums[0];
        temp[invalidSize][1] = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] != nums[i - 1]){
                invalidSize++;
                temp[invalidSize][0] = nums[i];
                temp[invalidSize][1] = 1;
            }else{
                temp[invalidSize][1] ++;
            }
        }
        Arrays.sort(temp, 0, invalidSize + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for(int i = 0; i < k; ++i){
            res[i] = temp[i][0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        solution347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

}
