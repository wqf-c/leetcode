package Dfs;

/**
 * @author wqf
 * @date 2020/11/24 23:31
 * @Email:284660487@qq.com
 */
public class Solution529 {

    int getNeighbor(char[][] board, int x, int y){
        if(x < 0 || y < 0 || y >= board.length || x >= board[0].length){
            return 0;
        }
        if(board[y][x] == 'M' || board[y][x] == 'X') return 1;
        else return 0;
    }

    boolean judgeNeibor(char[][] board, int x, int y){
        if(x < 0 || y < 0 || y >= board.length || x >= board[0].length){
            return false;
        }
        if(board[y][x] == 'E') return true;
        else return false;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        if(board[y][x] == 'M') {
            board[y][x] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y){
        int l1 = getNeighbor(board, x - 1, y - 1);
        int l2 = getNeighbor(board, x, y - 1);
        int l3 = getNeighbor(board, x + 1, y - 1);
        int l4 = getNeighbor(board, x - 1, y);
        int l5 = getNeighbor(board, x + 1, y);
        int l6 = getNeighbor(board, x - 1, y + 1);
        int l7 = getNeighbor(board, x,y + 1);
        int l8 = getNeighbor(board,x + 1, y + 1);
        int total = l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8;
        if(total > 0) {
            board[y][x] = (char) ('0' + total);
        }else{
            board[y][x] = 'B';
            if(judgeNeibor(board, x - 1, y - 1)) dfs(board, x - 1, y - 1);
            if(judgeNeibor(board, x, y - 1)) dfs(board, x, y - 1);
            if(judgeNeibor(board, x + 1, y - 1)) dfs(board, x + 1, y - 1);
            if(judgeNeibor(board, x - 1, y)) dfs(board, x - 1, y);
            if(judgeNeibor(board, x + 1, y)) dfs(board, x + 1, y);
            if(judgeNeibor(board, x - 1, y + 1)) dfs(board, x - 1, y + 1);
            if(judgeNeibor(board, x, y + 1)) dfs(board, x, y + 1);
            if(judgeNeibor(board, x + 1, y + 1)) dfs(board, x + 1, y + 1);
        }
    }
}
