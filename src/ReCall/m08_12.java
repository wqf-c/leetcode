package ReCall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2021/1/3 23:57
 * @Email:284660487@qq.com
 */
public class m08_12 {

    List<List<String>> rst = null;
    List<Integer> cols;
    int[] colsSave;
    public List<List<String>> solveNQueens(int n) {
        rst = new ArrayList<>();
        cols = new ArrayList<>();
        colsSave = new int[n];
        solve(0, n);
        return rst;
    }

    public void solve(int curRow, int n){
        for(int i = 0; i < n; ++i){
            if(judge(i, curRow)){
                if(curRow == n - 1){
                    List<String> list = new ArrayList<>();
                    for(int j = 0; j < n - 1; ++j){
                        char[] chars = new char[n];
                        Arrays.fill(chars, '.');
                        chars[cols.get(j)] = 'Q';
                        list.add(new String(chars));
                    }
                    char[] chars = new char[n];
                    Arrays.fill(chars, '.');
                    chars[i] = 'Q';
                    list.add(new String(chars));
                    rst.add(list);
                }else{
                    colsSave[i] = 1;
                    cols.add(i);
                    solve(curRow + 1, n);
                    colsSave[i] = 0;
                    cols.remove(cols.size() - 1);
                }
            }
        }
    }

    public boolean judge(int col, int row){
        if(colsSave[col] == 1) return false;
        for(int i = 0; i < row; ++i){
            if(Math.abs(cols.get(i) - col) == Math.abs(row - i)) return false;
        }
        return true;
    }

}
