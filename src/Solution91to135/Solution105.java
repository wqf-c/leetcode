package Solution91to135;

public class Solution105 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public int pIndex = 0;
    int findVal(int[] inorder, int left, int right, int val){
        for(int i = left; i <= right; ++i){
            if(inorder[i] == val) return i;
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = construct(inorder, preorder, 0, inorder.length - 1);
        return root;
    }

    public TreeNode construct(int[] inorder, int[] preorder, int left, int right){
        if(pIndex >= preorder.length) return null;
        int iIndex = findVal(inorder, left, right, preorder[pIndex]);
        TreeNode node = new TreeNode(preorder[pIndex++]);
        if(iIndex > left){
            node.left = construct(inorder, preorder, left, iIndex - 1);
        }
        if(iIndex < right){
            node.right = construct(inorder, preorder, iIndex +1, right);
        }
        return node;
    }

    public static void main(String[] args){
        Solution105 s = new Solution105();
        s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

}
