package SixFive.ReOrderArray13;

import java.util.Vector;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {
    public static void main(String[] args){

    }
    public void reOrderArray(int [] array) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i <= array.length-1; i++) {
            if (array[i]%2==1)
                vector.add(array[i]);
        }
        for (int i = 0; i <= array.length-1; i++) {
            if (array[i]%2==0)
                vector.add(array[i]);
        }
        for (int i = 0; i <= array.length-1; i++) {
            array[i] = vector.get(i);
        }
    }
}