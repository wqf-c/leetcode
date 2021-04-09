package Hot100;

/**
 * @author wqf
 * @date 2021/3/19 21:57
 * @Email:284660487@qq.com
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len / 2; ++i){
            for(int j = i; j < len - i - 1; ++j){
                int temp1 = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = matrix[i][j];
                int temp2 = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = temp1;
                int temp3 = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = temp2;
                matrix[i][j] = temp3;
            }
        }
       // System.out.println();
    }

    public static void main(String[] args){
        Solution48 solution48 = new Solution48();
        solution48.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
