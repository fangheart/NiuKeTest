package JavaCoder.String;

import org.junit.Test;

/**
 * Created by fangheart on 2017/4/19.
 */
/*
统计一个字符串中出现单词的个数
单词的前一个字符为空才代表出现的是单词。只需要用一个标志位记录前一个是否是空格即可 /
 */
public class Str2StringCount {
    @Test
    public void test() {
        System.out.println(wordCount("Hello   wolrd"));
    }

    public static int wordCount(String s){
        char cArr[] = s.toCharArray();
        int count = 0;
        int flag = 0;//0代表前面是空格
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ')
                flag = 0;
            else if(flag==0){
                flag = 1;
                count++;
            }
        }
        return count;
    }
}
