package SixFive.FindGreatestSumOfSubArray30;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
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

     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0 || array==null)
            return 0;
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (curSum<0){
                curSum = array[i];
            }else {
                curSum = curSum + array[i];
            }
            if (curSum>greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }
}