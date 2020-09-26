package Array.practice;

/**
 * @author wqf
 * @date 2020/9/24 23:27
 * @Email:284660487@qq.com
 */
public class insertSort {

    static void sort(){
        int[] nums = {3, 9, -1, 10, 20};
        for(int i = 0; i < nums.length - 1; ++i){

            int index = i;
            int save = nums[i + 1];
            while (index >= 0 && save < nums[index]){
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = save;
        }

        for(int i = 0; i < nums.length; ++i){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args){
        sort();
    }
}
