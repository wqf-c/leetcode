package CodeTop;

/**
 * @author wqf
 * @date 2021/5/18 1:13
 * @Email:284660487@qq.com
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int rst = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1' && !visited[i][j]){
                    rst++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return rst;
    }

    public void bfs(char[][] grids, int xIndex, int yIndex, boolean[][] visited){
        if(visited[xIndex][yIndex] || grids[xIndex][yIndex] == '0') return;
        visited[xIndex][yIndex] = true;
        if(xIndex - 1 >= 0){
            bfs(grids, xIndex - 1, yIndex, visited);
        }
        if(xIndex + 1 < grids.length){
            bfs(grids, xIndex + 1, yIndex, visited);
        }
        if(yIndex - 1 >= 0){
            bfs(grids, xIndex, yIndex - 1, visited);
        }
        if(yIndex + 1 < grids[0].length){
            bfs(grids, xIndex, yIndex + 1,visited);
        }
    }

}
