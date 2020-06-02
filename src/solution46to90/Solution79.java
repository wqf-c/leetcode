package solution46to90;

/**
 * Author: wqf
 * Date: 2020/4/14
 * Time: 22:34
 */
public class Solution79 {

  public static boolean exist(char[][] board, String word) {
    boolean used[][] = new boolean[board.length][board[0].length];
    for(int i = 0; i < board.length; ++i){
      for(int j = 0; j < board[0].length; ++j){
        if(board[i][j] == word.charAt(0)) {
          used[i][j] = true;
          if(findWay(board, i, j, word, 0, used)) return true;
        }
      }
    }
    return false;
  }

  static boolean findWay(char[][] board, int y, int x, String word, int index, boolean used[][]){
    if(index == word.length() - 1) return true;

    if(y < board.length - 1 && !used[y+1][x] && board[y + 1][x] == word.charAt(index + 1)){
      used[y + 1][x] = true;
      if(findWay(board, y + 1, x, word, index + 1, used)) return true;
      used[y + 1][x] = false;
    }

    if(x < board[0].length - 1 && !used[y][x + 1] && board[y][x + 1] == word.charAt(index + 1)){
      used[y][x + 1] = true;
      if(findWay(board, y, x + 1, word, index + 1, used)) return true;
      used[y][x + 1] = false;
    }

    if(y > 0 && !used[y-1][x] && board[y - 1][x] == word.charAt(index + 1)){
      used[y - 1][x] = true;
      if(findWay(board, y - 1, x, word, index + 1, used)) return true;
      used[y - 1][x] = false;
    }

    if(x > 0 && !used[y][x - 1] && board[y][x - 1] == word.charAt(index + 1)){
      used[y][x - 1] = true;
      if(findWay(board, y, x - 1, word, index + 1, used)) return true;
      used[y][x - 1] = false;
    }

    used[y][x] = false;
    return false;
  }

  public static void main(String[] args) {
    char board[][] =
      {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
      };
    System.out.println(exist(board, "ABCCED"));
  }
}
