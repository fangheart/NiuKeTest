package SixFive.NK40FindNumsAppearOnce;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
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
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
     */
    int index = 0;
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result^array[i];

        }
        index = findBit1(result);

        for (int i = 0; i < array.length; i++) {
            if (hasBit1(array[i])){
                num1[0] = num1[0]^array[i];
            }else {
                num2[0] = num2[0]^array[i];
            }
        }
    }
    public int findBit1(int a){
        int temp = a;
        while ((temp & 1)==0 && index<= 32){
            temp = temp >> 1;
            index++;
        }
        return index;
    }
    public boolean hasBit1(int a){
        a = a >> index;
        return (a & 1)==1;
    }

}