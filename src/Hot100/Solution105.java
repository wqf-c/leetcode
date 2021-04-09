package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wqf
 * @date 2021/4/3 17:49
 * @Email:284660487@qq.com
 */
public class Solution105 {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }
        return tree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode tree(int[] preOrder, int pStart, int[] inOrder, int iStart, int iEnd){
        if(iStart > iEnd || pStart >= preOrder.length) return null;
        if(iStart == iEnd) return new TreeNode(preOrder[pStart]);
        TreeNode node = new TreeNode(preOrder[pStart]);
        int findIndex = map.get(preOrder[pStart]);
        node.left = tree(preOrder, pStart + 1, inOrder, iStart, findIndex - 1);
        node.right= tree(preOrder, pStart + findIndex - iStart + 1, inOrder, findIndex + 1, iEnd);
        return node;
    }

}
