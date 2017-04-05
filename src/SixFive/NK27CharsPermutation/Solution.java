package SixFive.NK27CharsPermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
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
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        if (str!=null && str.toCharArray().length>0){
            PermutationHelper(str.toCharArray(),0,hashSet);
        }
        arrayList.addAll(hashSet);
        Collections.sort(arrayList);
        return arrayList;
    }

    public void PermutationHelper(char[] chars, int i, HashSet<String> hashSet) {
        if (i==chars.length-1){
            hashSet.add(new String(chars));
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars,i,j);
                PermutationHelper(chars,i+1,hashSet);
                swap(chars,i,j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        if (i!=j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}