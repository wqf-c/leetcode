package solution1to45;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: wqf
 * Date: 2020/2/19
 * Time: 20:33
 */
public class Solution36 {
  public static void main(String[] args) {
    char[][] c = new char[][]{
      {'5','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},
      {'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},
      {'4','.','.','8','.','3','.','.','1'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','6','.','.','.','.','2','8','.'},
      {'.','.','.','4','1','9','.','.','5'},
      {'.','.','.','.','8','.','.','7','9'}};
    isValidSudoku(c);
  }

  public static boolean isValidSudoku(char[][] board) {
    HashMap<Character, ArrayList<position>> points = new HashMap<>();
    for(int y = 0; y < board.length; y++){
      for(int x = 0; x < board[0].length; ++x){
        char ch = board[y][x];
        if(ch != '.'){
          if(points.get(ch) == null){
            ArrayList<position> l = new ArrayList<>();
            l.add(new position(x, y));
            points.put(ch, l);
          }else{
            ArrayList<position> l = points.get(ch);
            for(int i = 0; i < l.size(); ++i){
              position p = l.get(i);
              if(p.y == y || p.x == x || (Math.abs(p.x - x) < 3 && Math.abs(p.y - y) < 3 && p.x / 3 == x / 3 && p.y / 3 == y / 3)) {
               // System.out.println(p.x + " " + p.y + " " + x + " " + y + " " + ch);
                return false;
              }
            }
            l.add(new position(x, y));
          }
        }
      }
    }
    return true;
  }

  //用int的不同位来代表位置
  public boolean isValidSudoku1(char[][] board) {
    if(board == null)
      return false;
    if(board.length !=9)
      return false;
    int[] map = new int[9];
    for(int y=0; y<9; y++){
      if(board[y] == null || board[y].length != 9)
        return false;
      for(int x=0; x<9; x++){
        int key = board[y][x] - '1'; //key:数字
        if(key >= 0 && key <= 8) {  //1~9有效数字
          int index = (1<<x)     //Value:位置编码，最低9位存放列号
            | (1<<(y+9))    //中间9位存放行号
            | (1<<(x/3 + y/3*3 + 18));  // z为9宫格区域序号
          int old = map[key];
          if((old & index) == 0) //无重复，则按位或，加入位置集合
            map[key] = old | index;
          else    //有重复
            return false;
        }
      }
    }
    return true;

  }

  static class position{
    int x;
    int y;
    public position(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
