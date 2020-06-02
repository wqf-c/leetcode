package solution1to45;

import java.util.*;

/**
 * Author: wqf
 * Date: 2020/2/13
 * Time: 20:30
 */
public class Solution17 {

  public static void main(String[] args) {
    List<String> r = letterCombinations("23");
    for(String s : r){
      System.out.println(s);
    }
  }

  //都是分治算法，非递归的版本比递归要快很多
  public static String[] nmbers = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public static List<String> letterCombinations1(String digits) {

    if(digits.length() == 0 ){
      return new ArrayList<>();
    }else {
      return numbers(0, digits.length() - 1, digits);
    }
  }

  public static List<String> numbers(int left, int right, String number){
    if(left == right){
      int k = number.charAt(left) - '2';
      String s = nmbers[k];
      List<String> l = new ArrayList<>();
      for(int i = 0; i < s.length(); ++i){
        l.add(s.charAt(i) + "");
      }
      return l;
    }else{
      int mid = (left + right) / 2;
      List<String> leftN = numbers(left, mid, number);
      List<String> rightN = numbers(mid + 1, right, number);
      return merge(leftN, rightN);
    }
  }

  public static List<String> letterCombinations(String digits) {

    if(digits.length() == 0 ){
      return new ArrayList<>();
    }

    List<List<String>> lists = new ArrayList<>();

    for(int i = 0; i < digits.length(); ++i){
      char ch = digits.charAt(i);
      switch (ch){
        case '2':
          List<String> l = new ArrayList<>();
          Collections.addAll(l, "a", "b", "c");
          lists.add(l);
          break;
        case '3':
          List<String> l1 = new ArrayList<>();
          Collections.addAll(l1, "d", "e", "f");
          lists.add(l1);
          break;
        case '4':
          List<String> l2 = new ArrayList<>();
          Collections.addAll(l2, "g", "h", "i");
          lists.add(l2);
          break;
        case '5':
          List<String> l3 = new ArrayList<>();
          Collections.addAll(l3, "j", "k", "l");
          lists.add(l3);
          break;
        case '6':
          List<String> l4 = new ArrayList<>();
          Collections.addAll(l4, "m", "n", "o");
          lists.add(l4);
          break;
        case '7':
          List<String> l5 = new ArrayList<>();
          Collections.addAll(l5, "p", "q", "r", "s");
          lists.add(l5);
          break;
        case '8':
          List<String> l6 = new ArrayList<>();
          Collections.addAll(l6, "t", "u", "v");
          lists.add(l6);
          break;
        case '9':
          List<String> l7 = new ArrayList<>();
          Collections.addAll(l7, "w", "x", "y", "z");
          lists.add(l7);
          break;
      }
    }
    int interval = 1;
    int amount = lists.size();
    while (interval < amount){
      for(int i = 0; i < amount - interval; i += 2 * interval){

        List<String> tem = merge(lists.get(i), lists.get(i + interval));
        lists.set(i, tem);
      }
      interval = interval * 2;
    }
    return lists.get(0);
  }

  public static List<String> merge(List<String> left, List<String> right){
    List<String> result = new ArrayList<>();
    for(int i = 0; i < left.size(); ++i){
      for(int j = 0; j < right.size(); ++j){
        result.add(left.get(i) + right.get(j));
      }
    }
    return result;
  }
}
