package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Solution{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    };
    /*
        Title:same-tree
        Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null){
            if(p.val==q.val )
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            else
                return false;

        }
        else if(p==null&&q==null)
            return true;
        else
            return false;
    }
/*
title:symmetric-tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.
confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
*/
public boolean isSymmetric(TreeNode root) {
    if(root==null)
        return true;
    else {
        return isSame(root.left,root.right);
    }
}

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }if (left!=null&&right==null || left==null&&right!=null){
            return false;
        }else {
            return left.val == right.val && isSame(left.left,right.right) && isSame(left.right,right.left);
        }
}

    /*
    Title:binary-tree-level-order-traversal
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
    */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
            }
            if (flag)   res.add(list);
            else{
                Collections.reverse(list);
                res.add(list);
            }
            flag = !flag;
        }
        return res;
    }

    /*
    title:maximum-depth-of-binary-tree
    Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return l > r ? l+1:r+1;
    }
}