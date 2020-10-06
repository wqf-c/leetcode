package Array;

/**
 * @author wqf
 * @date 2020/10/6 0:56
 * @Email:284660487@qq.com
 */
public class Solution59 {

    public static int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int width = n;
        int i = 1;
        int count = 0;
        while (width > 0){
            for(int j = 0; j < width; ++j){
                rst[count][count + j] = i;
                i++;
            }
            for(int j = 0; j < width - 1; ++j){
                rst[count + 1 + j][count + width - 1] = i;
                i++;
            }
            for(int j = 0; j < width - 1; ++j){
                rst[count + width - 1][count + width - 2 - j] = i;
                i++;
            }
            for(int j = 0; j < width - 2; ++j){
                rst[count + width - 2 - j][count] = i;
                i++;
            }
            width -= 2;
            count++;
        }
        return rst;
    }

    public static void main(String[] args){
        generateMatrix(4);
    }
}
