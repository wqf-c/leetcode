package tree;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/11/15 23:49
 * @Email:284660487@qq.com
 */
public class SolutionOffer26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode bNode;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        bNode = B;
        return preOrder(A);
    }

    public boolean preOrder(TreeNode A){
        if(A.val == bNode.val){
            if(judge(A, bNode)){
                return true;
            }
        }
        if(A.left != null && preOrder(A.left)) return true;
        if(A.right != null && preOrder(A.right)) return true;
        return false;
    }

    boolean judge(TreeNode nodeA, TreeNode nodeB){
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        while (nodeB != null || !stackB.empty()){
            while (nodeB != null){
                if(nodeA == null) return false;
                if(nodeA.val != nodeB.val) return false;
                stackA.push(nodeA);
                stackB.push(nodeB);
                nodeB = nodeB.left;
                nodeA = nodeA.left;
            }
            if(!stackB.empty()){
                nodeA = stackA.pop();
                nodeA = nodeA.right;
                nodeB = stackB.pop();
                nodeB = nodeB.right;
            }
        }
        return true;
    }

    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if(A==null || B == null){
            return false;
        }
        //先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
        //只要有一个为true，就说明B是A的子结构
        return isSub(A,B)||isSubStructure1(A.left,B)||isSubStructure1(A.right,B);
    }

    public boolean isSub(TreeNode A,TreeNode B){
        //B为空，遍历完毕，则为子树
        if(B == null){
            return true;
        }

        //A为空 B不为空，或者值不相同，则不是子树
        if(A == null || A.val != B.val){
            return false;
        }
        //根结点相同后 再比较左右子节点
        return isSub(A.left,B.left)&&isSub(A.right,B.right);
    }
}
