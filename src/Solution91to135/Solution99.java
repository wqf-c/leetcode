package Solution91to135;

public class Solution99 {
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

  //todo
    public void recoverTree(TreeNode root) {
          if(root == null) return;;
          findValue(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int findValue(TreeNode node, int min, int max){
          if(node.val < min){
              int temp = node.val;
              node.val = min;
              return temp;
          }
          if(node.val > max){
              int temp = node.val;
              node.val = max;
              return temp;
          }
          if(node.left != null){
              int left = findValue(node.left, min, node.val);
              if(node.val < left) {
                  node.val = left;
                  return left;
              }
              if(left > max) return left;
          }
          if(node.right != null){
              int right = findValue(node.right, node.val, max);
              if(node.val > right) {
                  node.val = right;
                  return right;
              }
              if(right < min) return right;
          }
          return node.val;
    }
}
