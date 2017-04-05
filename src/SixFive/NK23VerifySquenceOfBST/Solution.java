package SixFive.NK23VerifySquenceOfBST;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
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
    递归解法
     */
    public boolean VerifySquenceOfBST2(int [] sequence) {
        int length = sequence.length - 1;
        if (length<0)
            return false;
        if (length==0){
            return true;
        }
        return juge(sequence,0,length);
    }

    private boolean juge(int[] sequence, int start, int root) {
        if (start>=root)
            return true;
        int i = root;
        while (i>start && sequence[i-1]>sequence[root])
            i--;
        for (int j = start; j < i-1; j++) {
            if (sequence[j]>sequence[root])
                return false;
        }
        return juge(sequence,start,i-1) && juge(sequence,i,root-1);
    }

    /*
//非递归
  //非递归也是一个基于递归的思想：
//左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
//最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件即可
//即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理
 //对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
//只需看看右子树的右子树是否符合要求即可
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        int size = sequence.length-1;
        if (size<0)
            return false;
        int i = 0;
        while (size>=0){
            while(sequence[i]<sequence[size]){
                i++;
            }
            while(sequence[i]>sequence[size]){
                i++;
            }

            if (i<size)
                return false;
            i=0;
            size--;
        }
        return true;
    }
}