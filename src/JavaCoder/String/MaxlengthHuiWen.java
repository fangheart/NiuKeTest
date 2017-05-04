package JavaCoder.String;

import org.junit.Test;

/**
 * Created by fangheart on 2017/5/4.
 */
/*
题目：所谓回文字符串，就是一个字符串，从左到右读和从右到左读是完全一样的，
比如：”aba”，”abba”.对于一个字符串，可以通过删除某些字符二编程回文字符串，
如：“cabebaf”,删除“c,e,f”后剩下子串“abba”就是回文字符串。
要求：给定任意一个字符串，字符串的最大长度1000，计算出最长的回文字符串长度。
输入：字符串
输出：最大的回文字符串的长度。

分析：回文即是从前到中和从后到中完全一致
那么如果第一个字符和最后一个字符相等，那么最长回文串长度就是中间的最长回文串+2
如果第一个字符和最后一个字符不相等，那么最长子串的长度就是去掉头字符的最长子字符串和去掉尾结点的最长子字符串长度
既有方程
            |p[i+1][j-1] + 2;(char[i]==char[j] i<j)
p[i][j]=    |p[i+1][j-1] + 1;(char[i]==char[j] i==j中间单个字符)
            |max(p[i+1][j],p[i][j-1])

 为了方便写循环
 p[i][j]代表j-i之间最大回文的长度，
 */
public class MaxlengthHuiWen {

    @Test
    public void test(){
        getLen("cabebaf");
        getLen2("cabebaf");
    }
    public void getLen2(String s){

        char c[] = (" "+s + " ").toCharArray();
        int n = c.length;
        int p[][] = new int[n][n];
        int maxLen = 0;

        for (int i = n-2; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (c[i]==c[j]&&i>j){
                    p[i][j]= p[i+1][j-1] + 2;
                }else if (c[i]==c[j]&&i==j){
                    p[i][j] = p[i+1][j-1] + 1;
                }else if(p[i+1][j]>=p[i][j-1]){
                    p[i][j] = p[i+1][j];
                }else
                    p[i][j] = p[i][j-1];
                if (p[i][j] > maxLen)
                    maxLen = p[i][j];
            }
        }
        System.out.println(maxLen);
    }
    public void getLen(String s){

        char c[] = (" "+s + " ").toCharArray();
        int n = c.length;
        int p[][] = new int[n][n];
        int maxLen = 0;

        for (int i = 1; i < n-1; i++) {
            for (int j = n-2; j >=i ; j--) {
                if (c[i]==c[j]&&i<j){
                    p[i][j]= p[i-1][j+1] + 2;
                }else if (c[i]==c[j]&&i==j){
                    p[i][j] = p[i-1][j+1] + 1;
                }else if(p[i-1][j]>=p[i][j+1]){
                    p[i][j] = p[i-1][j];
                }else
                    p[i][j] = p[i][j+1];
                if (p[i][j] > maxLen)
                    maxLen = p[i][j];
            }
        }
        System.out.println(maxLen);
    }
}
