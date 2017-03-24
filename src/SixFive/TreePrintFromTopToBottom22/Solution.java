package SixFive.TreePrintFromTopToBottom22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args){

    }
    /*
    用队列来实现层序遍历，然而却时间复杂度过大
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            arrayList.add(treeNode.val);
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);

        }
        return arrayList;
    }
/*
    用ArrayList来模拟队列
     */
public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root){
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    if (root == null) {
        return list;
    }
    queue.add(root);
    while (queue.size() != 0) {
        TreeNode temp = queue.remove(0);
        list.add(temp.val);
        if (temp.left != null){
            queue.add(temp.left);
        }
        if (temp.right != null) {
            queue.add(temp.right);
        }
    }
    return list;
}
}