package SixFive.NK43LeftRotateString;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
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
    方法一直接翻转
     */
    public String LeftRotateString2(String str,int n) {
        if (str==null||n>str.length())
            return "";
        else {
            char[] c = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = n; i < c.length; i++) {
                sb.append( c[i] );
            }
            for (int i = 0; i < n; i++) {
                sb.append( c[i] );
            }
            return sb.toString();
        }
    }
    /*
    方法二：三次翻转
     */
    public String LeftRotateString(String str,int n) {
        int l = str.length();
        if (str==null||n>l)
            return "";
        char[] c = str.toCharArray();
        swap( c,0,n-1 );
        swap( c,n,c.length-1 );
        swap( c,0,c.length-1 );
        String s = new String( c );
        return s;
    }
    public static void swap(char[] cArr,int front,int end){
        while(front < end){
            char tmp = cArr[end];
            cArr[end] = cArr[front];
            cArr[front] = tmp;
            front++;
            end--;
        }
    }
}