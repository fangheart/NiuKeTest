package SixFive.NK48AddWithoutPlus;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
类似题：交换两个变量a,b的值
基于加减法方式                 基于异或方式
a = a + b;                      a = a ^ b;
b = a - b;                      b = a ^ b;
a = a - b;                      a = a ^ b;
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
首先看十进制是如何做的： 5+7=12，三步走
第一步：相加各位的值，不算进位，得到2。
第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。

第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。

同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111

第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。

第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。

第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
     继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     */
    public int Add(int num1,int num2) {
        while (num2!=0){
            int sum = num1^num2;  //不考虑进位相加
            int carry = (num1&num2)<<1; //进位

            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}