package SixFive.NK66movingCount;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
地上有一个m行和n列的方格。
一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
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

    public int movingCount(int threshold, int rows, int cols)
    {
        int flag[][] = new int[rows][cols];
        return helper(0,0,rows,cols,flag,threshold);

    }

    /*
    递归思想走下去
     */
    public int helper(int i,int j,int rows,int cols,int flag[][],int threshold){
        int count = 0;
        //首先判断是否在超过边界，或者不满足条件，或者已经走过
        if(threshold<=0||i<0||i>=rows||j<0||j>=cols||(sum(i)+sum(j))>threshold||flag[i][j]==1)
            return 0;
        //如果一切符合条件变为1表示已经走过
        flag[i][j] = 1;
        //当前步加上向其他4个方向各能走的步数
        count = helper(i+1,j,rows,cols,flag,threshold)
                +helper(i-1,j,rows,cols,flag,threshold)
                +helper(i,j+1,rows,cols,flag,threshold)
                +helper(i,j-1,rows,cols,flag,threshold)+1;
        return count;
    }
    //判断位数之和
    public int sum(int i){
        int sum = 0;
        while(i>0){
            sum += i%10;
            i = i/10;
        }
        return sum;
    }


}