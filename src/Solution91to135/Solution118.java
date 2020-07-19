package Solution91to135;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < numRows; ++i){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(i == 0){
            }else if(i == 1){
                list.add(1);
            }else{
                List<Integer> lastList = lists.get(lists.size() - 1);
                 for(int j = 1; j < i; ++j){
                     list.add(lastList.get(j - 1) + lastList.get(j));
                 }
                 list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args){
        Solution118 s118 = new Solution118();
        s118.generate(5);
    }
}
