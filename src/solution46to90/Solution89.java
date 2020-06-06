package solution46to90;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {

    //¹«Ê½
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>();
        for(int i = 0; i < 1 << n; ++i){
            codes.add(i ^ i >> 1);
        }
        return codes;
    }

    //»ØËÝ


}
