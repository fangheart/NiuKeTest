package SixFive.BinaryTreeReset4;

/**
 * Created by FangHeart on 2017/3/19.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public static void main(String[] args){

    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return this.reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int start1,int end1,int [] in,int start2,int end2) {
        if (start1>end1 || start2>end2)
            return null;
        int rootData = pre[start1];
        TreeNode head = new TreeNode(rootData);
        //找到根节点位置
        int rootIndex = findIndexInArray(in,rootData,start2,end2);
        int offset = rootIndex - start2 - 1;
        //构建左子树
        TreeNode left = reConstructBinaryTree(pre,start1+1,start1+1+offset,in,start2,start2+offset);
        //构建右子树
        TreeNode right = reConstructBinaryTree(pre,start1+offset+2,end1,in,rootIndex+1,end2);

        head.left = left;
        head.right = right;
        return head;
    }
    private int findIndexInArray(int[] a, int rootData, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if(a[i]==rootData)
                return i;
        }
        return -1;
    }
}