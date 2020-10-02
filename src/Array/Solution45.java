package Array;

/**
 * @author wqf
 * @date 2020/10/2 21:09
 * @Email:284660487@qq.com
 */
public class Solution45 {

//    执行用时：
//            2 ms
//, 在所有 Java 提交中击败了
//93.84%
//    的用户
//    内存消耗：
//            40.8 MB
//, 在所有 Java 提交中击败了
//50.33%
//    的用户
    public int jump(int[] nums) {
        int left = 0, right, rst = 0;
        if(nums.length == 1) return 0;
        while (true){
            right = left + nums[left];
            if(right >= nums.length - 1) break;
            int max = 0;
            int nextL = 0;
            for(int i = left + 1; i <= right; ++i){
                if(i + nums[i] > max){
                    nextL = i;
                    max = i + nums[i];
                }
            }

            left = nextL;
            rst += 1;
        }
        return rst + 1;
    }
}
