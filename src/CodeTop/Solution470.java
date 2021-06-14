package CodeTop;

import java.util.Random;

/**
 * @author wqf
 * @date 2021/6/8 0:43
 * @Email:284660487@qq.com
 */
public class Solution470 {

    public int rand7(){
        return new Random().nextInt(7);
    }

    public int rand10() {
       // int temp = rand7() * rand7();  不是随机
        int idx = 0;
        while(true) {
            int col = rand7();
            int row = rand7();
            idx = (col - 1) * 7 + row;
            if(idx <= 40){
                break;
            }
        }
        return idx % 10 + 1;
    }

}
