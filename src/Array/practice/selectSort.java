package Array.practice;

/**
 * @author wqf
 * @date 2020/9/24 23:07
 * @Email:284660487@qq.com
 */
public class selectSort {

    static void sort(){
        int[] nums = {3, 9, -1, 10, 20};
        for(int i = 0; i < nums.length; ++i){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        for(int i = 0; i < nums.length; ++i){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args){
        sort();
    }
}
