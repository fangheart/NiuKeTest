package SixFive.NK65hasStringPathInMatrix;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
例如[a b c e s f c s a d e e]是3*4矩阵，其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，
因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
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
    /**
     用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归，找不到就回溯
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int flag[] = new int[matrix.length];
        for(int i=0;i<rows;i++){
            for (int j = 0; j<cols; j++){
                if(helper(matrix,rows,cols,i,j,str,0,flag))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i*cols + j;
        if(i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==1){//不符合条件或者是该格子字符不是要找的，或者该格子已经走过
            return false;
        }
        //如果该格子是下一个要找的
        if(k==str.length - 1)//长度达到要找的长度，证明全找到路径存在
            return true;
        //没有到达末尾
        flag[index] = 1;

        //判断下一步上下左右能否找到,分别在上下左右寻找
        if(helper(matrix,rows,cols,i-1,j,str,k+1,flag)
                ||helper(matrix,rows,cols,i+1,j,str,k+1,flag)
                ||helper(matrix,rows,cols,i,j-1,str,k+1,flag)
                ||helper(matrix,rows,cols,i,j+1,str,k+1,flag)
                ){
            return true;
        }
        //如果找不到回溯
        flag[index] = 0;
        return false;
    }


}