package SixFive.NK53StringisNumeric;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
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

    public boolean isNumeric2(char[] str) {
        //正则
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    public boolean isNumeric(char[] s) {
        if (s == null)
            return false;
        if(s.length==0)
            return false;
        if((s.length==1)&&(s[0]<'0'||s[0]>'9'))
            return false;
        if(s[0]=='+'||s[0]=='-'){
            if(s.length==2&&(s[1]=='.'))
                return false;
        }else if((s[0]<'0'||s[0]>'9')&&s[0]!='.')
            return false;//首位既不是符号也不是数字还不是小数点，当然是false
        int i = 1;
        while((i<s.length)&&(s[i]>='0'&&s[i]<='9'))
            i++;
        if(i<s.length&&s[i]=='.'){
            i++;
            if(i>=s.length) return false;
            while((i<s.length)&&(s[i]>='0'&&s[i]<='9'))
                i++;
        }
        if(i<s.length&&(s[i]=='e'||s[i]=='E')){
            i++;
            if((i<s.length)&&(s[i]=='+'||s[i]=='-')){
                i++;
                if(i<s.length)
                    while((i<s.length)&&(s[i]>='0'&&s[i]<='9'))
                        i++;
                else
                    return false;
            }
            else if(i<s.length){
                while((i<s.length)&&(s[i]>='0'&&s[i]<='9')) i++;
            }else return false;
        }
        if(i<s.length) return false;
        return true;
    }
}