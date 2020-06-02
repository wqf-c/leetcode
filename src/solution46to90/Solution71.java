package solution46to90;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 21:13
 */
public class Solution71 {

  public static void main(String[] args) {
    //"/..aa/...hidden/"
    System.out.println(simplifyPath("/../"));
//    String[] ss = "/../".split("/");
//    for(int i = 0; i < ss.length; ++i){
//      System.out.println(ss[i]);
//    }
  }
  public static String simplifyPath1(String path) {
    List<String> list = new ArrayList<>();
    String result = "";
    for(int i = 0; i < path.length();){
      char ch = path.charAt(i);
      if(ch != '.' && ch != '/'){
        StringBuilder sb = new StringBuilder();
        for(; i < path.length() && (path.charAt(i) != '.' && path.charAt(i) != '/');){
          sb.append(path.charAt(i));
          i ++;
        }
        list.add(sb.toString());
      }
      else if(ch == '.' && i+1 < path.length() && path.charAt(i + 1) == '.'){
        if(i+2 < path.length() && path.charAt(i+2) != '/'){
          //说明为目录
          StringBuilder sb = new StringBuilder();
          while (i < path.length() && path.charAt(i) != '/'){
            sb.append(path.charAt(i));
            i++;
          }
          list.add(sb.toString());
        }else{
          if(!list.isEmpty()){
            list.remove(list.size() - 1);
          }
        }
      }else if(ch == '.'){
        if((i + 1 < path.length() && path.charAt(i + 1) == '/') || i + 1 == path.length()) i++;
        else{
          StringBuilder sb = new StringBuilder();
          while (i < path.length() && path.charAt(i) != '/'){
            sb.append(path.charAt(i));
            i++;
          }
          list.add(sb.toString());
        }
      } else i++;
    }
    if(list.isEmpty()) result = "/";
    else{
      for(int i = 0; i < list.size(); ++i){
        result += ("/" + list.get(i));
      }
    }
    return result;
  }

  public static String simplifyPath(String path){
    String[] paths = path.split("/");
    String result = "";
    int remove = 0;
    for(int i = paths.length - 1; i >= 0; i--){
      if(paths[i].equals(".")) continue;
      else if(paths[i].equals("..")){
        remove++;
      }else if(paths[i].length() == 0){
        continue;
      }else{
        if(remove > 0){
          remove --;
        }else{
          result = "/" + paths[i] + result;
        }

      }
    }
    if(result.length() == 0) result = "/";
    return result;
  }
}
