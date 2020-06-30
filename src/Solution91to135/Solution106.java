package Solution91to135;

public class Solution106 {

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0) return null;
        pIndex = postorder.length - 1;
        TreeNode root = construct(inorder, postorder, 0, inorder.length - 1);
        return root;
    }

    public TreeNode construct(int[] inorder, int[] postorder, int left, int right){
        if(pIndex < 0) return null;
        int iIndex = findVal(inorder, left, right, postorder[pIndex]);
        TreeNode node = new TreeNode(postorder[pIndex--]);
        if(iIndex < right){
            node.right = construct(inorder, postorder, iIndex + 1, right);
        }
        if(iIndex > left){
            node.left = construct(inorder, postorder, left, iIndex - 1);
        }
        return node;
    }

    public static void main(String[] args){
        Solution106 s = new Solution106();
        s.buildTree(new int[]{2, 1}, new int[]{2, 1});
    }
}
