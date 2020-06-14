package solution46to90;

import java.util.ArrayList;
import java.util.List;

public class Solution90 {

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length != 0){
            sort(nums, 0, nums.length - 1);
            merge(list, new ArrayList<>(), 0, nums);
        }
        return list;
    }

    public static void merge(List<List<Integer>> lists, List<Integer> list, int index, int[] nums){
        if(index >= nums.length){
            List<Integer> l = new ArrayList<>();
            l.addAll(list);
            for(Integer i : list){
                System.out.print(i);
            }
            System.out.println();
            lists.add(l);
            return;
        }
        int currentNumLen = 1;
        for(int i = index + 1; i < nums.length && nums[i] == nums[index]; ++i){
            currentNumLen ++;
        }

        merge(lists, list, index + currentNumLen, nums);
        for(int i = 0; i < currentNumLen; ++i){
            list.add(nums[index]);
            merge(lists, list, index + currentNumLen, nums);
        }
        for(int i = 0; i < currentNumLen; ++i){
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsetsWithDup(nums);
    }
}
