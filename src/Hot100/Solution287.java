package Hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wqf
 * @date 2021/4/17 12:21
 * @Email:284660487@qq.com
 */
public class Solution287 {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) return num;
            else set.add(num);
        }
        return 0;
    }

    public int findDuplicate1(int[] nums) {
        int index = 0;
        int temp = 0;
        while (true){
            index = temp;
            if(nums[index] == 0){
                return index;
            }
            temp = nums[index];
            nums[index] = 0;
        }
    }

    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

}
