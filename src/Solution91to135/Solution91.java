package Solution91to135;

public class Solution91 {

    //»ØËÝ
    public int numDecodings(String s) {
        return encode(s, 0);
    }

    public int encode(String s, int index){
        if(index == s.length()){
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }
        int c1 = encode(s, index + 1);
        int c2 = 0;
        if(index < s.length() - 1 && ((s.charAt(index) == '2' && s.charAt(index + 1) <= '6') || s.charAt(index) == '1')){
            c2 = encode(s, index + 2);
        }
        return c1 + c2;
    }

    static void test(Integer c){
        c = 20;
    }

    //dp
    public int numDecodings1(String s) {
        int cur = 1;
        int pre = 1;
        for(int i = 1; i < s.length(); ++i){
            int temp = cur;
            if(s.charAt(i) == '0'){
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2'){
                    cur = pre;
                }else{
                    return 0;
                }
            }else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')){
                cur = cur + pre;
            }
            pre = temp;
        }
        return cur;
    }


    public static void main(String[] args) {
        Solution91 s = new Solution91();
        System.out.println(s.numDecodings("226"));
    }
}
