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
    public List<Integer> grayCode1(int n) {
        List<Integer> codes = new ArrayList<>();
        getCode(0, 1, codes, 0, n - 1);
        return codes;
    }
//0 2 1 3
    //1 3 0 2
    public void getCode(int n, int mask, List<Integer> codes, int index, int max){
        if(index == max){
            codes.add(n);
        }else{
            if(index % 2 == 0){
                getCode(n, mask << 1, codes, index + 1, max);
                getCode(n | mask, mask << 1, codes, index + 1, max);
            }else{
                getCode(n | mask, mask << 1, codes, index + 1, max);
                getCode(n, mask << 1, codes, index + 1, max);
            }
        }
    }



}
