package SixFive.JumpFloor8;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    public static void main(String[] args){

    }
    //递归解法
    public int JumpFloor(int target) {
        if (0==target)
            return 0;
        else if (1==target)
            return 1;
        else if (2==target)
            return 2;
        else {
            return (JumpFloor(target-1) + JumpFloor(target-2));
        }
    }
    //迭代解法
    public int JumpFloor2(int target){
        if (target==0 || target==1 || target==2)
            return target;
        else {
            // 第一阶和第二阶考虑过了，初始当前台阶为第三阶，向后迭代
            // 思路：当前台阶的跳法总数=当前台阶后退一阶的台阶的跳法总数+当前台阶后退二阶的台阶的跳法总数
            int lastNum = 2;//第三级台阶退后一节有几种跳法
            int lastlastNum = 1;//第三级台阶退后2节有几种跳法
            int sum=0;
            for (int i = 3; i <= target; i++) {
                sum = lastlastNum + lastNum;
                lastlastNum = lastNum;           // 后退一阶在下一次迭代变为后退两阶
                lastNum = sum;                   // 当前台阶在下一次迭代变为后退一阶
            }
            return sum;
        }

    }
}