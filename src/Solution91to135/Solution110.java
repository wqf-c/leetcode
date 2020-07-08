package Solution91to135;

public class Solution110 {

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lLen = treeLen(root.left);
        int rLen = treeLen(root.right);
        return flag && (Math.abs(lLen - rLen) <= 1);
    }

    int treeLen(TreeNode node){
        if(!flag) return -1;
        if(node == null) return 0;
        int lLen = treeLen(node.left);
        int rLen = treeLen(node.right);
        if (Math.abs(lLen - rLen) > 1){
            flag = false;
        }
        return Math.max(lLen, rLen) + 1;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node6.right = node8;

        Solution110 s = new Solution110();
       System.out.println(s.isBalanced(node1));

    }
}
