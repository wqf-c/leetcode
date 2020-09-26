package Array.practice;

/**
 * @author wqf
 * @date 2020/9/26 13:48
 * @Email:284660487@qq.com
 */
public class shellSort {

    static void sort(){
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        for(int gap = nums.length; gap > 0; gap = gap / 2){
            for(int i = gap; i < nums.length; ++i){
                int j = i;
                int temp = nums[j];
                while (j - gap >= 0){
                    if(nums[j - gap] < temp){
                        break;
                    }else{
                        nums[j] = nums[j - gap];
                        j -= gap;
                    }
                }
                nums[j] = temp;
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
