package NiuKeTest3rd;

import java.util.Scanner;

/**
 * Created by FangHeart on 2017/5/20.
 */
/*
牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:最多只改变一个数,就可以使得这个连续的子序列是一个严格上升的子序列,牛牛想知道这个连续子序列最长的长度是多少。
输入描述:
输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 10^5),即数列的长度;
第二行n个整数a_i, 表示数列中的每个数(1 ≤ a_i ≤ 10^9),以空格分割。


输出描述:
输出一个整数,表示最长的长度。

输入例子:
6
7 2 3 1 5 6

输出例子:
5

牛牛的数列
分析

正着枚举记录一下当前位置的连续上升子序列长度,倒着也做一遍。
最后枚举一个连接点即可。

参考code
 */
public class ZuiDaZiXuLie {
    public static int max(int a,int b){
        return a<=b ? b:a;
    }
    public static void main(String[] args){
        int maxn = 100005;
        int a[] = new int[maxn];
        int pre[] = new int[maxn];
        int suf[] = new int[maxn];
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        a[0] = Integer.MAX_VALUE;
        a[n + 1] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++)
            pre[i] = a[i - 1] < a[i] ? pre[i - 1] + 1 : 1;
        for(int i = n; i >= 1; i--)
            suf[i] = a[i] < a[i + 1] ? suf[i + 1] + 1 : 1;
        int ans = 1;
        for(int i = 1; i <= n; i++) {
            ans = max(ans, pre[i - 1] + 1);
            ans = max(ans, suf[i + 1] + 1);
            if(a[i + 1] - a[i - 1] >= 2)
                ans = max(ans, pre[i - 1] + suf[i + 1] + 1);
        }
        System.out.println( ans );
    }
}
