package solution46to90;
import java.util.*;

/**
 * Author: wqf
 * Date: 2020/4/13
 * Time: 17:24
 */
public class BellmanFord {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("输入点数:");
    int totalPoints = sc.nextInt();
    System.out.print("输入边最小权值:");
    int minNum = sc.nextInt();
    System.out.print("输入边最大权值:");
    int maxNum = sc.nextInt();
    List<Edge> list = new ArrayList<>();
    for(int i = 0; i < totalPoints; ++i){
      for(int j = 0; j < totalPoints; ++j){
        if(i == j) continue;
        Random rand = new Random();
        int randomNum = rand.nextInt(maxNum - minNum) + minNum;
        if(randomNum %2 == 0){
          list.add(new Edge(i+"", j+"", randomNum));
        }
      }
    }
    Edge[] edges = new Edge[list.size()];
    for(int i = 0; i < list.size(); ++i){
      edges[i] = list.get(i);
    }
    //存放到各个节点所需要消耗的时间
    HashMap<String, Integer> costMap = new HashMap<String, Integer>();
    //到各个节点对应的父节点
    HashMap<String, String> parentMap = new HashMap<String, String>();


    //初始化各个节点所消费的，当然也可以再遍历的时候判断下是否为Null
    //i=0的时候
    costMap.put("0", 0); //源点
    for(int i = 1; i < totalPoints; ++i){
      costMap.put(i + "", Integer.MAX_VALUE);
    }


    //进行节点数n-1次循环
    for (int i = 1; i < costMap.size(); i++) {
      boolean hasChange = false;
      for (int j = 0; j < edges.length; j++) {
        Edge edge = edges[j];
        //该边起点目前总的路径大小
        int startPointCost = costMap.get(edge.getStartPoint()) == null ? 0 : costMap.get(edge.getStartPoint());
        //该边终点目前总的路径大小
        int endPointCost = costMap.get(edge.getEndPoint()) == null ? Integer.MAX_VALUE : costMap.get(edge.getEndPoint());
        //如果该边终点目前的路径大小 > 该边起点的路径大小 + 该边权重 ，说明有更短的路径了
        if (endPointCost > (startPointCost + edge.getWeight())) {
          costMap.put(edge.getEndPoint(), startPointCost + edge.getWeight());
          parentMap.put(edge.getEndPoint(), edge.getStartPoint());
          hasChange = true;
        }
      }
      if (!hasChange) {
        //经常还没达到最大遍历次数便已经求出解了，此时可以优化为提前退出循环
        break;
      }
    }

    //在进行一次判断是否存在负环路
    boolean hasRing = false;
    for (int j = 0; j < edges.length; j++) {
      Edge edge = edges[j];
      int startPointCost = costMap.get(edge.getStartPoint()) == null ? 0 : costMap.get(edge.getStartPoint());
      int endPointCost = costMap.get(edge.getEndPoint()) == null ? Integer.MAX_VALUE : costMap.get(edge.getEndPoint());
      if (endPointCost > (startPointCost + edge.getWeight())) {
        System.out.print("\n图中存在负环路，无法求解\n");
        hasRing = true;
        break;
      }
    }

    if (!hasRing) {
      //打印出到各个节点的最短路径
      for (String key : costMap.keySet()) {
        System.out.print("\n到目标节点" + key + "最低耗费:" + costMap.get(key));
        if (parentMap.containsKey(key)) {
          List<String> pathList = new ArrayList<String>();
          String parentKey = parentMap.get(key);
          while (parentKey != null) {
            pathList.add(0, parentKey);
            parentKey = parentMap.get(parentKey);
          }
          pathList.add(key);
          String path = "";
          for (String k : pathList) {
            path = path.equals("") ? path : path + " --> ";
            path = path + k;
          }
          System.out.print("，路线为" + path);
        }
      }
    }


  }


  /**
   * 代表"一条边"的信息对象
   *
   * @author Administrator
   */
  static class Edge {
    //起点id
    private String startPoint;
    //结束点id
    private String endPoint;
    //该边的权重
    private int weight;

    public Edge(String startPoint, String endPoint, int weight) {
      this.startPoint = startPoint;
      this.endPoint = endPoint;
      this.weight = weight;
    }

    public String getStartPoint() {
      return startPoint;
    }

    public String getEndPoint() {
      return endPoint;
    }

    public int getWeight() {
      return weight;
    }
  }
}