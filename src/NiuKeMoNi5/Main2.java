package NiuKeMoNi5;

import java.util.Scanner;

/**
 * Created by fangheart on 2017/7/25.
 */
/*
牛牛有一些字母卡片,每张卡片上都有一个小写字母,所有卡片组成一个字符串s。牛牛一直认为回文这种性质十分优雅,于是牛牛希望用这些卡片拼凑出一些回文串,但是有以下要求:
1、每张卡片只能使用一次
2、要求构成的回文串的数量最少
牛牛想知道用这些字母卡片,最少能拼凑出多少个回文串。
例如: s = "abbaa",输出1,因为最少可以拼凑出"ababa"这一个回文串
s = "abc", 输出3,因为最少只能拼凑出"a","b","c"这三个回文串
输入描述:
输入包括一行,一个字符串s,字符串s长度length(1 ≤ length ≤ 1000).
s中每个字符都是小写字母


输出描述:
输出一个整数,即最少的回文串个数。

输入例子1:
abc

输出例子1:
3
 */

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] a = new int[26];
        char[] c = s.toCharArray();

        for (char cc : c){
            a[cc-'a']++; //标注每个字符有多少个
        }
        int ans = 1;//记录答案

        for (int i = 0; i < 26; i++) {
            if((a[i]&1)==1){//找到一个奇数个数的字符作为字符串的中心
                a[i]--;
                break;
            }
        }

        //其余的字符每两个相同的放在回文串左右即可，也就是直接对2取模，剩下的单个字符作为一个回文串
        for (int i = 0; i < 26; i++) {
            a[i]%=2;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i]==1)
                ans++;
        }
        System.out.println(ans);

    }
}

//以下解法内存超出限制
//public class Main2 {
//    public static int minCount = 0;
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//
//        //System.out.println(isHuiWen(s));
//        Main2.minCount = s.length();
//        StringBuffer sb = new StringBuffer();
//        for (int i = s.length(); i >=1 ; i--) {
//            combine(s.toCharArray(),0,i,sb,s);
//        }
//        System.out.println(Main2.minCount);
//
//    }
//
////    public static int getCount(String s){
////        int getLenth = s.length();
////
////    }
//    public static boolean isHuiWen(String s){
//        StringBuffer sb = new StringBuffer(s);
//        String str1 = sb.reverse().toString();
//        if (str1.equals(s)){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public static void combine(char[] c,int begin,int len,StringBuffer sb,String s){
//        if(len==0){
//            if (isHuiWen(sb.toString())) {
//                //System.out.println(sb.toString().length());
//                //System.out.println("11111  " + sb.toString());
//                if (sb.toString().length()==c.length){
//                    minCount = 1;
//                }else {
//                    int count = 1+c.length-sb.toString().length();
//                    if (count<minCount)
//                        minCount = count;
//                }
//
//            }
//            else{
//                ZhuanHuan(sb.toString().toCharArray(),0,s);
//            }
//        }
//        if (begin==c.length)
//            return;
//        sb.append(c[begin]);
//        combine(c,begin+1,len-1,sb,s);
//        sb.deleteCharAt(sb.length()-1);
//        combine(c,begin+1,len,sb,s);
//    }
//
//    public static void ZhuanHuan(char[] c,int i,String s){
//        if (i==c.length-1){
//            if (isHuiWen(new String(c))){
//                //System.out.println(c.length);
//                //System.out.println("22222  " + new String(c));
//                if (s.length()==c.length){
//                    minCount = 1;
//                }else {
//                    int count = 1+s.length()-c.length;
//                    if (count<minCount)
//                        minCount = count;
//                }
//            }
//        }else {
//            for (int j = i; j < c.length; j++) {
//                swap(c,i,j);
//                ZhuanHuan(c,i+1,s);
//                swap(c,i,j);
//            }
//        }
//    }
//
//    public static void swap(char[] c,int i,int j){
//        if (i!=j){
//            char temp = c[i];
//            c[i] = c[j];
//            c[j]=temp;
//        }
//    }
//}
