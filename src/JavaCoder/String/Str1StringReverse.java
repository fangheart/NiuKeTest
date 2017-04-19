package JavaCoder.String;

import org.junit.Test;

/**
 * Created by fangheart on 2017/4/19.
 */
/*
字符串翻转
//实现字符串的反转 ，例如how are you 变 you are how
// 以及单词的反转，单词的反转即是先全部反转，然后在把每个单词反转
 */
public class Str1StringReverse {

    @Test
    public void test(){
        System.out.println(swapWords("how are you"));
    }

    public static String swapWords(String s){
        char cArr[] = s.toCharArray();
        //翻转全部的字符
        swap(cArr,0,cArr.length-1);
        //翻转每个单词
        int begin = 0;
        for (int i = 1; i < cArr.length; i++) {
            if (cArr[i]==' '){
                swap(cArr,begin,i-1);
                begin=i+1;
            }
        }
        swap(cArr,begin,cArr.length-1);
        return new String(cArr);
    }

    private static void swap(char[] cArr, int start, int end) {
        while (start<end){
            char temp = cArr[start];
            cArr[start] = cArr[end];
            cArr[end] = temp;
            start++;
            end--;
        }
    }
}
