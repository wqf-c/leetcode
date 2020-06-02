package solution46to90;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Author: wqf
 * Date: 2020/4/13
 * Time: 22:41
 */
public class Solution77 {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    if(k > n) return result;
    bine(n, n, k);
    return result;
  }

  public void bine(int n, int restN, int restK){
    if(restK == 0){
      List<Integer> add = new ArrayList<>();
      for(int i = 0; i < temp.size(); ++i){
        add.add(temp.get(i));
      }
      result.add(add);
      return;
    }
    if(restK > restN) return;
      bine(n, restN - 1, restK);
      temp.add(n - restN + 1);
      bine(n, restN - 1, restK - 1);
      temp.remove(temp.size() - 1);
  }
}
