package SixFive.PrintMinNumber32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
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
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String s = "";
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(numbers[i]);
        }
        Collections.sort(arrayList,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 =  o2 + "" + o1;

                return str1.compareTo(str2);

            }
        });
        for(int j:arrayList){
            s+=j;
        }
        return s;
    }

}