package Hot100;

/**
 * @author wqf
 * @date 2021/4/14 23:41
 * @Email:284660487@qq.com
 */
public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, 0, m, n);
    }

    public boolean search(int[][] matrix, int target, int top, int left, int m, int n){
        if(matrix[top][left] > target) return false;
        if(matrix[top][left] == target) return true;
        int j = Math.min(m, n);
        for(int i = 1; i < j; ++i){
            if(matrix[top + i][left + i] == target) return true;
            if(matrix[top + i][left + i] > target){
                return search(matrix, target, top, left + i, i, n - i) || search(matrix, target, top + i, left, m - i, i);
            }
        }
        if(m == n) return false;
        else if(m > n){
            return search(matrix, target, top + n, left, m - n, n);
        }else{
            return search(matrix, target, top, left + m, m, n - m);
        }
    }


    public static void main(String[] args) {
        Solution240 solution240 = new Solution240();
        System.out.println(solution240.searchMatrix(new int[][]{
                {1,  2, 3, 4, 5},
                {6,  7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        }, 15));
    }

}
