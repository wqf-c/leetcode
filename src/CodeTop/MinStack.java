package CodeTop;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/6/5 12:38
 * @Email:284660487@qq.com
 */
public class MinStack {

    //借助额外空间
    //可以另外申请一个栈空间，存放对应的min

    //不借助额外空间，stack里存min与当前元素差值
    Stack<Long> stack = null;
    int min = 0;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.empty()){
            stack.push(0l);
            min = val;
        }else{
            stack.push(Long.valueOf(val) - min);
            min = Math.min(min, val);
        }
    }

    public void pop() {
        Long diff = stack.peek();
        stack.pop();
        if(diff < 0){
            min = (int)(min - diff);
        }
    }

    public int top() {
        Long diff = stack.peek();
        if(diff < 0){
            return min;
        }else{
            return (int)(min + diff);
        }
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.pop();
        System.out.println(minStack.top());
    }

}
