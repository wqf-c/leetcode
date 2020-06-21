package Solution91to135;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public List<TreeNode> genTrees(int start, int end){
      List<TreeNode> trees = new LinkedList<>();
      if(start > end){
          trees.add(null);
          return trees;
      }

      for(int i = start; i <= end; ++i){
          List<TreeNode> leftTrees = genTrees(start, i - 1);
          List<TreeNode> rightTrees = genTrees(i + 1, end);
          for(TreeNode lTree : leftTrees){
              for(TreeNode rTree: rightTrees){
                  TreeNode current = new TreeNode(i);
                  current.left = lTree;
                  current.right = rTree;
                  trees.add(current);
              }
          }
      }
      return trees;
  }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<>();
        }else{
            return genTrees(1, n);
        }
    }
}
