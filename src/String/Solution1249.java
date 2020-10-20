package String;

/**
 * @author wqf
 * @date 2020/10/17 16:50
 * @Email:284660487@qq.com
 */
public class Solution1249 {

    public String minRemoveToMakeValid(String s) {
        char[] temp1 = new char[s.length()];
        int temp1Index = 0;
        char[] temp2 = new char[s.length()];
        int temp2Index = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == ')' && count == 0) continue;
            else{
                if(c == '('){
                    count++;
                }else if(c == ')'){
                    count--;
                }
                temp1[temp1Index] = c;
                temp1Index++;
            }

        }
        count = 0;
        temp2Index = temp2.length - 1;
        for(int i = temp1Index - 1; i >= 0; i--){
            char c = temp1[i];
            if(c == '(' && count == 0) continue;
            else{
                if(c == ')'){
                    count++;
                }else if(c == '('){
                    count--;
                }
                temp2[temp2Index] = c;
                temp2Index--;
            }
        }
        return new String(temp2, temp2Index+1, temp2.length- 1 - temp2Index);
    }

    public static void main(String[] args){
        Solution1249 solution1249 = new Solution1249();
        System.out.println(solution1249.minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
