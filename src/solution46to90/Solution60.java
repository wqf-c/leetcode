package solution46to90;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/3/6
 * Time: 1:41
 */
public class Solution60 {

  public static void main(String[] args) {
    //System.out.println(getPermutation(3, 5));
//    int n = 10;
//    boolean[] flags = new boolean[n];
//    for(int i = 0; i < n; ++i){
//      System.out.println(flags[i]);
//    }
//    int a = 10;
//    int b = 3;
//    int c = (int)(2.99999999999999999999999999999999999);
//    System.out.println(c);
//    double beishu = Math.ceil(a/ b);
//    System.out.println(beishu);
    System.out.println(getPermutation(3, 3));
  }

  //题中要求大小顺序,不能用这种交换的方法
//  static int  current = 0;
//  public static String getPermutation(int n, int k) {
//    int[] list = new int[n];
//    for(int i = 0; i < n; ++i){
//      list[i] = i + 1;
//    }
//    backtrack(list, k, 0, n);
//    StringBuilder sb = new StringBuilder();
//    for(int i = 0; i < list.length; ++i) sb.append(list[i]);
//    return sb.toString();
//  }
//
//  public static boolean backtrack(int[] list, int k, int first, int n){
//    if(first == n){
//      current ++;
//      System.out.println(current);
//      for(int i = 0; i < list.length; ++i){
//        System.out.print(list[i] + " ");
//      }
//      System.out.println();
//      if(current == k) return true;
//    }
//    for(int i = first; i < n; ++i){
//      int temp = list[first];
//      list[first] = list[i];
//      list[i] = temp;
//      boolean flag = backtrack(list, k, first + 1, n);
//      if(flag) return true;
//      list[i] = list[first];
//      list[first] = temp;
//    }
//    return false;
//  }

  int cnt=0;
  int k;
  public String getPermutation1(int n, int k) {
    this.k=k;
    List<List<Integer>> res = new ArrayList<>();
    int[] visited = new int[n];
    int[] nums=new int[n];
    for(int i=0;i<n;i++)
    {
      nums[i]=i+1;
    }
    backtrack(res, nums, new ArrayList<Integer>(), visited);
    StringBuilder sb=new StringBuilder();
    List<Integer> list=new ArrayList<>(res.get(0));
    for(int i=0;i<n;i++)
    {
      sb.append(list.get(i));
    }
    return sb.toString();
  }

  private boolean backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
    if (tmp.size() == nums.length) {
      cnt++;
      if(cnt==k){
        res.add(new ArrayList<>(tmp));
        return true;
      }

    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i] == 1) continue;
      visited[i] = 1;
      tmp.add(nums[i]);
      boolean flag = backtrack(res, nums, tmp, visited);
      if(flag) return true;
      visited[i] = 0;
      tmp.remove(tmp.size() - 1);
    }
    return false;
  }

  //既然所有的全排列是从小到大，那么可以对每一位的数字进行定位。
  // 例如，假如给定题目为（5,46）。固定第一位数，后面4位的全排列数为24，
  // math.ceil(46/24)=2,即处于第1位数的第二个循环中，即第一位数为2.同理，
  // 对于固定第二位数，math.ceil(（46-24）/6)=4,即处于第2位数的第四个循环中（此时列表移除了已确定的数字2），
  // 即第2位数为5.同理，可依次推理出最后结果为“25341”.总复杂度为O（n）.
  public static int getJiec(int n){
    int res = 1;
    for(int i = 1; i <= n; ++i){
      res *= i;
    }
    return res;
  }
  public static String getPermutation(int n, int k) {
    StringBuilder sb = new StringBuilder();
    boolean[] flags = new boolean[n];
    for(int i = n; i >= 1; --i){
      int jiec = getJiec(i - 1);
      double beishu = Math.ceil((double) (k) / (double) jiec);
     // System.out.println("beishu:" + beishu);
      k = k - ((int)beishu - 1) * jiec;
      int count = 0;
      for(int j = 0; j < n; ++j){
        if(!flags[j]){
          count ++;
          if(count == (int)beishu){
            flags[j] = true;
        //    System.out.println(j +1);
            sb.append(j + 1);
            break;
          }
        }
      }
      if(k == 0){
        break;
      }
    }
    for(int i = 0; i < n; ++i){
      if(!flags[i]) sb.append(i + 1);
    }
    return sb.toString();
  }
}
