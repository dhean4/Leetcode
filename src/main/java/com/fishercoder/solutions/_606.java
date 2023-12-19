package com.fishercoder.solutions;

import com.fishercoder.common.classes.TreeNode;

public class _606 {

    public static class Solution1 {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            String result = "" + t.val;
            String left = tree2str(t.left);
            String right = tree2str(t.right);
            if ("".equals(left) && "".equals(right)) {
                return result;
            }
            if ("".equals(left)) {
                return result + "()(" + right + ")";
            }
            if ("".equals(right)) {
                return result + "(" + left + ")";
            }
            return result + "(" + left + ")(" + right + ")";
        }
    }

    public static class Solution2 {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            preorder(t, sb);
            return sb.toString();
        }

        private void preorder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val);
            if (root.left != null) {
                sb.append("(");
                preorder(root.left, sb);
                sb.append(")");
            }
            if (root.right != null) {
                if (root.left == null) {
                    sb.append("()");
                }
                sb.append("(");
                preorder(root.right, sb);
                sb.append(")");
            }
        }
    }

}
