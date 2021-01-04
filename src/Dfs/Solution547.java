package Dfs;

/**
 * @author wqf
 * @date 2020/11/27 22:55
 * @Email:284660487@qq.com
 */
public class Solution547 {

    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[][] visited = new boolean[N][N];
        int rst = 0;
        for(int i = 0; i < N; ++i){
            boolean flag = false;
            for(int j = 0; j < N; ++j){
                if(!visited[i][j] && M[i][j] == 1){
                    flag = true;
                    dfs(visited, M, i, j);
                }
            }
            if(flag) rst++;
        }
        return rst;
    }

    void dfs(boolean[][] visited, int[][] M, int y, int x){
        visited[y][x] = true;
        visited[x][y] = true;
        for(int i = 0; i < M.length; ++i){
            if(!visited[x][i] && M[x][i] == 1){
                dfs(visited, M, x, i);
            }
        }
    }

    public int findCircleNum1(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int n = M.length;
        int count = 0;

        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs1(M, vis, i);
                count++;
            }
        }

        return count;
    }

    public void dfs1(int[][] M, int[] vis, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && vis[j] == 0) {
                vis[j] = 1;
                dfs1(M, vis, j);
            }
        }
    }

}
