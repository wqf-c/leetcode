package Hot100;

import java.util.List;

/**
 * @author wqf
 * @date 2021/4/10 13:35
 * @Email:284660487@qq.com
 */
public class MinStack {

    private int min = 0;
    private int[] data;
    private int dataIndex;
    private int dataSize = 5;

    public MinStack() {
        data = new int[dataSize];
        dataIndex = 0;
    }

    public void push(int val) {
        if(dataIndex == dataSize){
            dataSize *= 2;
            int[] temp = new int[dataSize];
            for(int i = 0; i < dataIndex; ++i){
                temp[i] = data[i];
            }
            data = temp;
        }
        data[dataIndex] = val;
        dataIndex++;
        if(dataIndex == 1) min = val;
        else{
            if(val < min) min = val;
        }

    }

    public void pop() {
        dataIndex--;
        min = dataIndex > 0 ? data[0] : 0;
        for(int i = 0; i < dataIndex; ++i){
            if(min > data[i]) min = data[i];
        }
    }

    public int top() {
        return data[dataIndex-1];
    }

    public int getMin() {
        return min;
    }

}
