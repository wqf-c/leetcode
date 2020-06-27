package Solution91to135;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

  void inorder(TreeNode node, List<Integer> nums){
          if(node == null) return;
          inorder(node.left, nums);
          nums.add(node.val);
          inorder(node.right, nums);
  }

  void change(TreeNode node, int x, int y, int count){
      if(count == 0 || node == null) return;
      if(node.val == x || node.val == y){
          node.val = (node.val == x ? y : x);
          count --;
      }
      change(node.left, x, y, count);
      change(node.right, x, y, count);
  }

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int x = -1, y = -1;

        for(int i = 0; i < nums.size() - 1; ++i){
            if(nums.get(i + 1) < nums.get(i)){
                y = nums.get(i + 1);
                if(x == -1) x = nums.get(i);
                else break;
            }
        }
        change(root, x, y, 2);
    }

    //栈
    public void recoverTree1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, pred = null;
        while (!stack.empty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pred != null && pred.val > root.val){
                y = root;
                if(x == null) x = pred;
                else break;
            }
            pred = root;
            root = root.right;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    //morris
    public void recoverTree2(TreeNode root){
        TreeNode s1 = null, s2 = null, pre = null;
        TreeNode cur = root;
        while (cur != null){
            if(cur.left != null){
                TreeNode predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }else{
                    if(pre != null && pre.val > cur.val){
                        s2 = cur;
                        if(s1 != null) s1 = pre;
                        else break;
                    }
                    pre = cur;
                    predecessor.right = null;
                    cur = cur.right;
                }
            }else{
                if(pre != null && pre.val > cur.val){
                    s2 = cur;
                    if(s1 != null) s1 = pre;
                    else break;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        int temp = s1.val;
        s1.val = s2.val;
        s2.val = s1.val;
    }


}
