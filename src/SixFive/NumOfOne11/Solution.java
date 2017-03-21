package SixFive.NumOfOne11;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public static void main(String[] args) {

    }


    public int NumberOf1_two(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
    /*
    将数字减一与原来数字相与1的数字就会减一，直到n等于0那么就结束。
    例如1100 n-1 后 1011 相与后 1000。
     */
public int NumberOf1(int n) {
  int count = 0;
    while(n!= 0){
        count++;
        n = n & (n - 1);
        }
    return count;
  }
}