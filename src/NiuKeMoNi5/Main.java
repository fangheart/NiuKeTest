package NiuKeMoNi5;

import java.util.Scanner;
/*
如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1和或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
输入描述:
输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成


输出描述:
输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解

输入例子1:
abaababaab

输出例子1:
6
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();


        System.out.println(getCount(s));


    }
    public static int getCount(String s){
        if (s.length()<2||s.length()>200||s==null)
            return 0;
        for (int i = s.length()-1; i >0 ; i--) {
            if (isDuiOu(s.substring(0,i)))
                return i;
        }
        return 0;
    }
    public static boolean isDuiOu(String s){
        String str1 = s.substring(0,s.length()/2);
        String str2 = s.substring(s.length()/2);
        if (str1.equals(str2))
            return true;
        else
            return false;
    }
}
