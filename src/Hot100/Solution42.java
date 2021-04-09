package Hot100;

/**
 * @author wqf
 * @date 2021/3/18 22:00
 * @Email:284660487@qq.com
 */
public class Solution42 {

    public int trap(int[] height) {
        int rst = 0;
        int[] leftMax = new int[height.length];
        int lMax = 0;
        for(int i = 0; i < height.length; ++i){
            if(height[i] > lMax) lMax = height[i];
            leftMax[i] = lMax;
        }
        int rMax = 0;
        for(int i = height.length - 1; i >= 0; --i){
            if(height[i] > rMax) rMax = height[i];
            rst += Math.min(rMax, leftMax[i]) - height[i];
        }
        return rst;
    }

}
