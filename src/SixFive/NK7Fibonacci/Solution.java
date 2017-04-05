package SixFive.NK7Fibonacci;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */
public class Solution {
    public static void main(String[] args){

    }
    //递归，但是递归时间复杂度过大，所思考其他方法
    public int Fibonacci2(int n) {
        if (0==n)
            return 0;
        else if (1==n){
            return 1;
        }else{
            return Fibonacci2(n-2) + Fibonacci2(n-1);
        }
    }
    public int Fibonacci(int n) {
        int prePreNum = 0;
        int preNum = 1;
        int sum = 0;
        if (0==n)
            return 0;
        else if (1==n){
            return 1;
        }else{
            for (int i = 2; i <=n; i++) {
                sum = prePreNum + preNum;
                prePreNum = preNum;
                preNum = sum;
            }
            return sum;
    }

    }

}