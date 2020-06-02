package solution46to90;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * Author: wqf
 * Date: 2020/3/31
 * Time: 14:52
 */
public class SPFA {
  /**
   * @param args
   */
  public long[] result;   //用于得到第s个顶点到其它顶点之间的最短距离
  //数组实现邻接表存储
  class edge{
    public int a;//边的起点
    public int b;//边的终点
    public int value;//边的值
    public edge(int a,int b,int value){
      this.a=a;
      this.b=b;
      this.value=value;
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SPFA spafa=new SPFA();
    Scanner scan=new Scanner(System.in);
    System.out.print("输入顶点个数:");
    int n=scan.nextInt();
    System.out.print("输入顶点s:");
    int s=scan.nextInt();
    System.out.print("输入边最小权值:");
    int minNum = scan.nextInt();
    System.out.print("输入边最大权值:");
    int maxNum = scan.nextInt();
   // int p=20;

    List<edge> list = new ArrayList<>();
    int k = 0;
    for(int i = 0; i < n; ++i){
      for(int j = i + 1; j < n; ++j){
        Random rand = new Random();
        int randomNum = rand.nextInt(maxNum - minNum) + minNum;
        if(randomNum % 2 == 0){
          list.add(spafa.new edge(i, j, randomNum));
          list.add(spafa.new edge(j, i, randomNum));
        }
      }
    }
    edge[] A=new edge[list.size()];
    for(int i = 0; i < list.size(); ++i){
      A[i] = list.get(i);
    }
 //   A[0] = spafa.new edge(0,1,5);
//    A[1] = spafa.new edge(0,2,7);
//    A[2] = spafa.new edge(0,6,2);
//    A[3] = spafa.new edge(1,3,9);
//    A[4] = spafa.new edge(1,6,3);
//    A[5] = spafa.new edge(2,4,8);
//    A[6] = spafa.new edge(3,5,4);
//    A[7] = spafa.new edge(4,5,5);
//    A[8] = spafa.new edge(4,6,4);
//    A[9] = spafa.new edge(5,6,6);
//    A[10] = spafa.new edge(1,0,5);
//    A[11] = spafa.new edge(2,0,7);
//    A[12] = spafa.new edge(6,0,2);
//    A[13] = spafa.new edge(3,1,9);
//    A[14] = spafa.new edge(6,1,3);
//    A[15] = spafa.new edge(4,2,8);
//    A[16] = spafa.new edge(5,3,4);
//    A[17] = spafa.new edge(5,4,5);
//    A[18] = spafa.new edge(6,4,4);
//    A[19] = spafa.new edge(6,5,6);


    if(spafa.getShortestPaths(n,s,A)){
      for(int i=0;i<spafa.result.length;i++){
        System.out.println(spafa.result[i]+" ");
      }
    }else{
      System.out.println("存在负环");
    }
  }
  /*
   * 参数n:给定图的顶点个数
   * 参数s:求取第s个顶点到其它所有顶点之间的最短距离
   * 参数edge:给定图的具体边
   * 函数功能：如果给定图不含负权回路，则可以得到最终结果，如果含有负权回路，则不能得到最终结果
   */
  private boolean getShortestPaths(int n, int s, edge[] A) {
    // TODO Auto-generated method stub
    ArrayList<Integer> list = new ArrayList<Integer>();
    result=new long[n];
    boolean used[]=new boolean[n];
    int num[]=new int[n];
    for(int i=0;i<n;i++){
      result[i]=Integer.MAX_VALUE;
      used[i]=false;
    }
    result[s]=0;//第s个顶点到自身距离为0
    used[s]=true;//表示第s个顶点进入数组队
    num[s]=1;//表示第s个顶点已被遍历一次
    list.add(s); //第s个顶点入队
    while(list.size()!=0){
      int a=list.get(0);//获取数组队中第一个元素
      list.remove(0);//删除数组队中第一个元素
      for(int i=0;i<A.length;i++){
        //当list数组队的第一个元素等于边A[i]的起点时
        if(a==A[i].a&&result[A[i].b]>(result[A[i].a]+A[i].value)){
          result[A[i].b]=result[A[i].a]+A[i].value;
          if(!used[A[i].b]){
            list.add(A[i].b);
            num[A[i].b]++;
            if(num[A[i].b]>n){
              return false;
            }
            used[A[i].b]=true;//表示边A[i]的终点b已进入数组队
          }
        }
      }
      used[a]=false; //顶点a出数组队
    }
    return true;
  }
}
