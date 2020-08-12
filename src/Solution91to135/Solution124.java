package Solution91to135;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution124 {
     int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        func(root);
        return max;
    }

    int func(TreeNode root){

        int left = 0;
        boolean leftFLag = false;
        if(root.left != null){
            leftFLag = true;
            left = func(root.left);
        }
        int right = 0;
        boolean rightFlag = false;
        if(root.right != null){
            right = func(root.right);
            rightFlag = true;
        }
        int now = 0;
        if(leftFLag && rightFlag){
            now = Math.max(Math.max(Math.max(Math.max(Math.max(left, right), root.val), left + root.val), right + root.val), left + right + root.val);
        }else if(leftFLag && !rightFlag){
            now = Math.max(Math.max(Math.max(root.val, left), root.val + left), root.val);
        }else if(rightFlag && !leftFLag){
            now = Math.max(Math.max(Math.max(root.val, right), root.val + right), root.val);
        }else{
            now = root.val;
        }
        if(now > max) max = now;
        int bigeer = (left > right ? left : right);
        return root.val + (bigeer > 0 ? bigeer : 0);
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.right = node9;
        Solution124 s = new Solution124();
        s.maxPathSum(node1);
        System.out.println(s.max);
    }
}
