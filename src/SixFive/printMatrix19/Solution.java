package SixFive.printMatrix19;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵：
[1 2 3 4]
[5 6 7 8]
[9 10 11 12]
[13 14 15 16]
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
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
//主体循环部分才5行。其实是有规律可循的。将每一层的四个边角搞清楚就可以打印出来了
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length==0)
            return result;
        int n = matrix.length;
        int m = matrix[0].length;
        if (m==0)
            return result;
        int layer = (Math.min(n,m)-1)/2 + 1;//层数
        for (int i = 0; i < layer; i++) {
            //从左到右
            for (int j = i; j < m - i; j++) {
                result.add(matrix[i][j]);//左上角
            }
            //从右上到右下
            for (int j = i + 1; j < n - i; j++) {
                result.add(matrix[j][m - i - 1]);//右上角
            }
            //从右到左
            for (int j = m - i - 2; j >= i && (n - i - 1 != i); j--) {
                result.add(matrix[n - i - 1][j]);//右下角
            }
            //左下到左上
            for (int j = n - i - 2; j > i && (m - i - 1 != i); j--) {
                result.add(matrix[j][i]);//左下角
            }
        }
        return result;

    }
}