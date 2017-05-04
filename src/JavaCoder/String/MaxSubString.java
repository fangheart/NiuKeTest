package JavaCoder.String;

import org.junit.Test;

/**
 * Created by fangheart on 2017/5/4.
 */
/*
这是一道标准的动态规划问题，求两个字符串的最大公共子串
例如 String a = "abcde"
    String b = "abc"
    那么最长公共子串为abc

    可以建立一个二维数组p[i][j]代表到达字符串1的位置，字符串j位置时候的最大公共字符串
    可以得到如下公式
                | "" (String1char[i]!=String2char[j])
    p[i][j]=    | String1char[i]或者String2char[j]  (i=0或者j=0)
                | p[i-1][j-1] + char (String1char[i]==String2char[j])
 */
public class MaxSubString {

    @Test
    public void test(){
        System.out.println(getSubString("abcdaasdjhjkasdaa","abcasfsadsdaa"));
    }
    public String getSubString(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        int maxLen = 0;
        String lcs = "";

        char char1,char2;
        String p[][] = new String[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                char1 = str1.charAt(i);
                char2 = str2.charAt(j);

                if (char1!=char2)
                    p[i][j] = "";
                else {
                        if (i == 0)
                            p[i][j] = String.valueOf(char1);
                        else if (j == 0)
                            p[i][j] = String.valueOf(char2);
                        else
                            p[i][j] = p[i - 1][j - 1] + String.valueOf(char1);

                        if (p[i][j].length()>maxLen){
                            maxLen = p[i][j].length();
                            lcs = p[i][j];
                        }else if (p[i][j].length()==maxLen){
                            lcs = lcs +","+p[i][j];
                        }
                }
            }
        }
        return lcs;

    }
}
