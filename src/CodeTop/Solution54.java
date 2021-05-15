package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/5/15 23:44
 * @Email:284660487@qq.com
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        int xIndex = 0, yIndex = 0, height = matrix.length, width = matrix[0].length;
        while (height > 0 && width > 0){

            for(int i = xIndex; i < xIndex + width; ++i){
                rst.add(matrix[yIndex][i]);
            }
            for(int i = yIndex + 1; i < yIndex + height; ++i){
                rst.add(matrix[i][xIndex + width - 1]);
            }
            if(height >= 2){
                for(int i = xIndex + width - 2; i >= xIndex; --i){
                    rst.add(matrix[yIndex + height - 1][i]);
                }
            }
            if(width >= 2){
                for(int i = yIndex + height - 2; i > yIndex; --i){
                    rst.add(matrix[i][xIndex]);
                }
            }
            height -= 2;
            width-=2;
            xIndex += 1;
            yIndex += 1;
        }
        return rst;
    }

}
