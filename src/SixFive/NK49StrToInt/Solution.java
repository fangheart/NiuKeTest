package SixFive.NK49StrToInt;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空


输出描述:
如果是合法的数值表达则返回该数字，否则返回0

输入例子:
+2147483647
    1a33

输出例子:
2147483647
    0
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
    public int StrToInt(String str) {
        if (str=="" || str.length()==0)
            return 0;
        int flag = 0;
        char [] a = str.toCharArray();
        if (a[0]=='-') {
            flag = 1;
            a[0] = '0';
        }
        if (a[0]=='+') {
            a[0] = '0';
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]>'9' || a[i]<'0')
                return 0;
            sum = sum*10 + a[i] - '0';
        }
        return flag==0?sum : sum*-1;
    }
}