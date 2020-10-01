package Array;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/10/1 22:09
 * @Email:284660487@qq.com
 */
public class Solution42 {

    class Position{
        int position;
        int height;
    }
    public int trap(int[] height) {
        int res = 0;
        int start = 0;
        for(int i = 0; i < height.length - 1; ++i){
            if(height[i + 1] < height[i]){
                start = i;
                break;
            }
        }
        Stack<Position> stack = new Stack<>();
        for(int i = start + 1; i < height.length; ++i){
            if(height[i] < height[i - 1]){
                Position p = new Position();
                p.position = i;
                p.height = height[i - 1] - height[i];
                stack.push(p);
            }
            if(height[i] > height[i - 1]){
                int h = height[i] - height[i - 1];
                while (!stack.empty() && h > 0){
                    Position p = stack.pop();
                    if(p.height < h){
                        res += p.height * (i - p.position);
                        h -= p.height;
                    }else{
                        res += h * (i - p.position);
                        p.height -= h;
                        h = 0;
                        if(p.height > 0) stack.push(p);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution42 s42 = new Solution42();
        s42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
