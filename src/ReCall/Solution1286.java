package ReCall;

import java.util.*;

/**
 * @author wqf
 * @date 2021/1/9 23:34
 * @Email:284660487@qq.com
 */

class CombinationIterator {

    private char[] characters;
    private int combinationLength;
    private Queue<String> list;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters.toCharArray();
        this.combinationLength = combinationLength;
        list = new LinkedList<>();
        char[] temp = new char[this.combinationLength];
        traversal(this.characters, 0, 0, temp);
    }

    private void traversal(char[] characters, int curIndex, int len, char[] temp){
        if(len == combinationLength){
            list.offer(new String(temp));
            return;
        }
        if(curIndex >= characters.length) return;
        temp[len] = characters[curIndex];
        traversal(characters, curIndex + 1, len + 1, temp);
        traversal(characters, curIndex + 1, len, temp);
    }

    public String next() {
        return list.poll();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

public class Solution1286 {

    public static void main(String[] args){
        CombinationIterator iterator = new CombinationIterator("abc", 2);
    }
}

