package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/20
 * Time: 18:00
 */
public class Solution37 {

  public static void main(String[] args) {

  }
  public void solveSudoku(char[][] board) {
    boolean[][] checkRow = new boolean[9][9];
    boolean[][] checkColumn = new boolean[9][9];
    boolean[][] checkBlock = new boolean[9][9];
    for(int i = 0; i < board.length; ++i){
      for(int j = 0; j < board[0].length; ++j){
        char ch = board[i][j];
        if(ch != '.'){
          //num: 0 -> 9
          int num = ch - '1';
          //列
          checkRow[i][num] = true;
          //行
          checkColumn[j][num] = true;
          checkBlock[i / 3 * 3 + j / 3][num] = true;
        }
      }
    }
    dfs(board, checkRow, checkColumn, checkBlock, 0);
  }

  public static boolean dfs(char[][] board, boolean[][] checkRow, boolean[][] checkColumn, boolean[][] checkBlock, int index){
    int row = index / 9;
    int col = index - row * 9;
    if(index == 81) return true;
    if(board[row][col] == '.'){
      for(int i  = 0; i < 9; ++i){
        int block = row / 3 * 3 + col / 3;
        if(!checkRow[row][i] && !checkColumn[col][i] && !checkBlock[block][i]){
          checkBlock[block][i] = true;
          checkColumn[col][i] = true;
          checkRow[row][i] = true;
          board[row][col] = (char) ('1' + i);
          if(dfs(board, checkRow, checkColumn, checkBlock, index + 1)){
            return true;
          }else{
            checkBlock[block][i] = false;
            checkColumn[col][i] = false;
            checkRow[row][i] = false;
            board[row][col] = '.';
          }
        }
      }
      return false;
    }else{
      return dfs(board, checkRow, checkColumn, checkBlock, index + 1);
    }
  }
}
