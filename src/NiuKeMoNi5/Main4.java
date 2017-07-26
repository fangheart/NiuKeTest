package NiuKeMoNi5;

import java.util.Scanner;

/**
 * Created by FangHeart on 2017/7/26.
 */
/*
牛牛喜欢彩色的东西,尤其是彩色的瓷砖。牛牛的房间内铺有L块正方形瓷砖。每块砖的颜色有四种可能:红、绿、蓝、黄。给定一个字符串S, 如果S的第i个字符是'R', 'G', 'B'或'Y',那么第i块瓷砖的颜色就分别是红、绿、蓝或者黄。
牛牛决定换掉一些瓷砖的颜色,使得相邻两块瓷砖的颜色均不相同。请帮牛牛计算他最少需要换掉的瓷砖数量。
输入描述:
输入包括一行,一个字符串S,字符串长度length(1 ≤ length ≤ 10),字符串中每个字符串都是'R', 'G', 'B'或者'Y'。


输出描述:
输出一个整数,表示牛牛最少需要换掉的瓷砖数量

输入例子1:
RRRRRR

输出例子1:
3


因为有4种颜色可以轮转,所以我们直接两个两个的统计是否是相同颜色的个数即可。
 */

public class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        int cnt = 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i]==c[i-1]){//如果相同i跳过两个
                cnt++;
                i++;
            }
        }

        System.out.println(cnt);
    }
}
