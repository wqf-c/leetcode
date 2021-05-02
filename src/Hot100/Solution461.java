package Hot100;

/**
 * @author wqf
 * @date 2021/4/24 13:39
 * @Email:284660487@qq.com
 */
public class Solution461 {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int rst = 0;
        while (z != 0){
            if(z % 2 == 1){
                rst++;
            }
            z = z >>> 1;
        }
        return rst;
    }

}
