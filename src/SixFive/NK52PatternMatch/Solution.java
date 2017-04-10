package SixFive.NK52PatternMatch;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
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
当模式中的第二个字符不是“*”时：
  1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
  2、如果
  字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

  而当模式中的第二个字符是“*”时：
  如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
  如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
  1、模式后移2字符，相当于x*被忽略；
  2、字符串后移1字符，模式后移2字符；相当于匹配一个
  3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；相当于匹配多位
  这里需要注意的是：Java里，要时刻检验数组是否越界。
     */

    public boolean match(char[] str, char[] pattern) {
        if (pattern==null || str==null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str,strIndex,pattern,patternIndex);

    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检查二者都到达尾部，匹配成功
        if (str.length==strIndex && pattern.length==patternIndex) {
            return true;
        }
        //pattern先到尾部匹配失败
        if (strIndex!=str.length && patternIndex==pattern.length)
            return false;

        //正则第二个字符是*，且字符串第1个跟正则第1个匹配,分3种匹配模式；
        // 如不匹配，模式后移2位
        if (patternIndex+1<pattern.length && pattern[patternIndex+1]=='*'){
            if ((strIndex!=str.length && str[strIndex]==pattern[patternIndex])
                    ||(strIndex!=str.length && pattern[patternIndex]=='.')){
                //字符串第一个和正则第一个匹配
                //模式忽略x*直接后移
                return matchCore(str,strIndex,pattern,patternIndex+2)||
                        //字符后移1，正则后移2相当于只匹配一个
                        matchCore(str,strIndex+1,pattern,patternIndex+2)
                        //字符后移1，正则不懂，相当于匹配多个
                        ||matchCore(str,strIndex+1,pattern,patternIndex);
            }else{
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }

        //正则第二个字符不是*,如果第一个字符匹配，则都后移以为，否则返回false
        if ((strIndex!=str.length && pattern[patternIndex]==str[strIndex])||
                (strIndex!=str.length&&pattern[patternIndex]=='.')){
            return matchCore(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }

}