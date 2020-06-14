package solution46to90;

import java.util.ArrayList;
import java.util.List;

public class Solution90 {

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base�д�Ż�׼��
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
            while (array[j] >= base && i < j) {
                j--;
            }

            // �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
            while (array[i] <= base && i < j) {
                i++;
            }

            // �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // ����׼���ŵ��м��λ�ã���׼����λ��
        array[left] = array[i];
        array[i] = base;

        // �ݹ飬�������׼����������ִ�к�����ͬ���Ĳ���
        // i��������Ϊ������ȷ���õĻ�׼ֵ��λ�ã������ٴ���
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
