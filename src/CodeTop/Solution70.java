package CodeTop;

/**
 * @author wqf
 * @date 2021/5/30 12:02
 * @Email:284660487@qq.com
 */
public class Solution70 {

    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int lastStep = 1, lastPrevStep = 0;
        for(int i = 1; i <= n; ++i){
            int cur = lastStep + lastPrevStep;
            lastPrevStep = lastStep;
            lastStep = cur;
        }
        return lastStep;
    }

}
