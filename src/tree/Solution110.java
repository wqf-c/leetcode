package tree;

/**
 * @author wqf
 * @date 2020/11/5 23:36
 * @Email:284660487@qq.com
 */
public class Solution110 {


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

      boolean flag = true;
    public boolean isBalanced(TreeNode root) {
          if(root == null) return true;
          if(root.left == null && root.right == null) return true;
          judge(root);
          return flag;
    }

    public int judge(TreeNode node){
          if(!flag) return 0;
          if(node == null) return 0;
          int rightHeight = judge(node.right);
          int leftRight = judge(node.left);
          if(Math.abs(rightHeight - leftRight) > 1){
              flag = false;
              return 0;
          }
          return Math.max(rightHeight, leftRight) + 1;
    }

}
