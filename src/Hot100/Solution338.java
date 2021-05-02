package Hot100;

/**
 * @author wqf
 * @date 2021/4/22 0:10
 * @Email:284660487@qq.com
 */
public class Solution338 {

    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        rst[0] = 0;
        if(num == 0) return rst;
        for(int i = 1; i <= num; ++i){
            if(rst[i] == 0){
                rst[i] = rst[i - 1] + 1;
                int n = rst[i];
                for(int j = i * 2; j <= num; j*=2){
                    rst[j] = n;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();
        solution338.countBits(5);
    }

}
