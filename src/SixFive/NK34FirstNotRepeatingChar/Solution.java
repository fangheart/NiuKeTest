package SixFive.NK34FirstNotRepeatingChar;

import java.util.HashMap;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
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
HashMap法
     */
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (hashMap.containsKey(c[i])){
                int times = hashMap.get(c[i]);
                hashMap.put(c[i],++times);
            }else {
                hashMap.put(c[i],1);
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (hashMap.get(c[i])==1)
                return c[i];
        }
        return -1;
    }
}