package CodeTop;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/5/15 22:40
 * @Email:284660487@qq.com
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                int num = stack1.pop();
                stack2.push(num);
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.empty()){
            while (!stack1.empty()){
                int num = stack1.pop();
                stack2.push(num);
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }

}
