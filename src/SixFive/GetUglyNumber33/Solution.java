package SixFive.GetUglyNumber33;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
把只包含因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
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
该思路： 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
     */
    public int GetUglyNumber_Solution(int index) {
        if (index==0 || index==1)
            return index;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int i2=0,i3=0,i5=0;
        while (arrayList.size()<index){
            int m2 = arrayList.get(i2)*2;
            int m3 = arrayList.get(i3)*3;
            int m5 = arrayList.get(i5)*5;

            int min = Math.min(m2,Math.min(m3,m5));
            arrayList.add(min);
            if (min==m2){
                i2++;
            }
            if (min==m3){
                i3++;
            }
            if (min==m5){
                i5++;
            }
        }
        return arrayList.get(arrayList.size()-1);
    }
}