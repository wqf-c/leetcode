package CodeTop;

/**
 * @author wqf
 * @date 2021/5/22 15:38
 * @Email:284660487@qq.com
 */
public class Solution42 {

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int rst = 0;
        int[] leftMax = new int[height.length];
        int lM = height[0], rM = height[height.length - 1];
        leftMax[0] = lM;
        for(int i = 1; i < height.length; ++i){
            lM = Math.max(lM, height[i]);
            leftMax[i] = lM;
        }
        for(int i = height.length - 2; i > 0; --i){
            rM = Math.max(rM, height[i]);
            rst += Math.min(rM, leftMax[i]) - height[i];
        }
        return rst;
    }

}
