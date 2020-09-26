package Array.practice;



/**
 * @author wqf
 * @date 2020/9/24 22:57
 * @Email:284660487@qq.com
 */
public class bubbleSort {

    public static void sort(){
        int[] nums = {3, 9, -1, 10, 20};

        for(int i = 0; i < nums.length; ++i){
            boolean flag = false;
            for(int j = 1; j < nums.length - i; ++j){
                if(nums[j] < nums[j - 1]){
                    flag = true;
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
            if(!flag) break;
        }
        for(int i = 0; i < nums.length; ++i){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args){
        sort();
    }
}
