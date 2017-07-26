package NiuKeMoNi5;

import java.util.Scanner;

/**
 * Created by FangHeart on 2017/7/26.
 */
/*
牛牛从生物科研工作者那里获得一段字符串数据s,牛牛需要帮助科研工作者从中找出最长的DNA序列。DNA序列指的是序列中只包括'A','T','C','G'。牛牛觉得这个问题太简单了,就把问题交给你来解决。
例如: s = "ABCBOATER"中包含最长的DNA片段是"AT",所以最长的长度是2。
输入描述:
输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串中只包括大写字母('A'~'Z')。


输出描述:
输出一个整数,表示最长的DNA片段

输入例子1:
ABCBOATER

输出例子1:
2

 */
public class Main5 {
    public static void main(String[] args){
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();
        char[] c = s.toCharArray();

        int maxCount = Integer.MIN_VALUE;
        int curCount = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]=='A'||c[i]=='T'||c[i]=='C'||c[i]=='G'){
                curCount++;
                if (curCount>maxCount)
                    maxCount = curCount;
            }else{
                curCount = 0;
            }
        }

        System.out.println(maxCount);
    }
}
