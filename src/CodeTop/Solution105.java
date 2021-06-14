package CodeTop;

/**
 * @author wqf
 * @date 2021/6/12 23:28
 * @Email:284660487@qq.com
 */
public class Solution105 {

    int index = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(index == preorder.length || left > right){
            return null;
        }
        index++;
        TreeNode node = new TreeNode(preorder[index]);
        if(left == right){
            return node;
        }
        //这里可以用hashMap优化
        int idx = left;
        for(int i = left; i <= right; ++i){
            if(inorder[i] == preorder[index]){
                idx = i;
                break;
            }
        }
        node.left = build(preorder, inorder, left, idx - 1);
        node.right = build(preorder, inorder, idx + 1, right);
        return node;
    }

}
