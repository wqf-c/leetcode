package Bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/12/5 17:43
 * @Email:284660487@qq.com
 */
public class Solution130 {

    //...只需要检查与四条边的O连通的O即可
    public void solve1(char[][] board) {
        if(board == null || board.length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int y = 0; y < board.length; ++y){
            for(int x = 0; x < board[0].length; ++x){
                if(board[y][x] == 'O'){
                    List<Integer[]> list = new ArrayList<>();

                    boolean flag = bfs1(board, x, y, list, visited);
                    if(flag){
                        for(Integer[] visit : list){
                            board[visit[0]][visit[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public boolean bfs1(char[][] board, int x, int y, List<Integer[]> list, boolean[][] visited){
        if(x < 0 || y < 0 || y >= board.length || x >= board[0].length){
            return false;
        }
        if(visited[y][x]) return true;
        if(board[y][x] == 'X') return true;
        if(board[y][x] == 'O'){
            Integer[] position = new Integer[2];
            position[0] = y;
            position[1] = x;
            list.add(position);
        }
        visited[y][x] = true;
        boolean left = bfs1(board, x - 1, y, list, visited);
        boolean right = bfs1(board, x + 1, y, list, visited);
        boolean top = bfs1(board, x, y - 1, list, visited);
        boolean bottom = bfs1(board, x, y + 1, list, visited);
        return left && right && top && bottom;
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        for(int i = 0; i < width; ++i){
            if(!visited[0][i] && board[0][i] == 'O'){
                bfs(board, i, 0, visited);
            }
            if(!visited[height - 1][i] && board[height - 1][i] == 'O'){
                bfs(board, i, height - 1, visited);
            }
        }
        for(int i = 0 ; i < height; ++i){
            if(!visited[i][0] && board[i][0] == 'O'){
                bfs(board, 0, i, visited);
            }
            if(!visited[i][width - 1] && board[i][width - 1] == 'O'){
                bfs(board, width - 1, i, visited);
            }
        }
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(!visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    public void bfs(char[][] board, int x, int y, boolean[][] visited){
        if(x < 0 || y < 0 || y >= board.length || x >= board[0].length){
            return;
        }
        if(board[y][x] == 'X') return;
        if(visited[y][x]) return;
        visited[y][x] = true;
        bfs(board, x - 1, y, visited);
        bfs(board, x + 1, y, visited);
        bfs(board, x, y - 1, visited);
        bfs(board, x, y + 1, visited);
    }

    public static void main(String[] args){
        Solution130 solution130 = new Solution130();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solution130.solve1(board);
    }
}
