package Hot100;

/**
 * @author wqf
 * @date 2021/4/11 22:39
 * @Email:284660487@qq.com
 */
public class Solution200 {



    public int numIslands(char[][] grid) {
        int areaSize = 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < flag.length; ++i){
            for (int j = 0; j < flag[0].length; ++j){
                flag[i][j] = false;
            }
        }
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1' && !flag[i][j]){
                    dfs(grid, flag, i, j);
                    areaSize++;
                }
            }
        }
        return areaSize;
    }

    public void dfs(char[][] grad, boolean[][] flag, int positionX, int positionY){
        if(positionX < 0 || positionX >= grad.length) return;
        if(positionY < 0 || positionY >= grad[0].length) return;
        if(flag[positionX][positionY]) return;
        if(grad[positionX][positionY] == '0') return;
        flag[positionX][positionY] = true;
        dfs(grad, flag, positionX - 1, positionY);
        dfs(grad, flag, positionX + 1, positionY);
        dfs(grad, flag, positionX, positionY + 1);
        dfs(grad, flag, positionX, positionY - 1);
    }

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
    }

}
