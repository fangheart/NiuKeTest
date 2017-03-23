package SixFive.NumOfOne11;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public static void main(String[] args){

    }
    /*
    正常解法
     */
    public int NumberOf1(int n) {
        int count = 0;
        if (n==0)
            return 0;
        else {
            while (n != 0) {
                n = n & (n-1);
                count++;
            }
        }
        return count;
    }
    /*
    用java工具类
     */
    public int NumberOf12(int n) {
        return Integer.toBinaryString(n).replace("0","").length();
    }
}