package SixFive.NK54FirstAppearingOnceChar;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
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
    int hashtable[] = new int[256];
    StringBuffer stringBuffer = new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        stringBuffer.append(ch);
        if (hashtable[ch]==0)
            hashtable[ch]=1;
        else
            hashtable[ch] += 1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char str[] = stringBuffer.toString().toCharArray();
        for (char c : str) {
            if (hashtable[c]==1)
                return c;
        }
        return '#';
    }

}