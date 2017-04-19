package JavaCoder.String;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fangheart on 2017/4/19.
 */
/*
/
判断两个字符串是否有相同的字符组成 如aaaabbc与abcbaaa就是。组成字符及个数都相同
解决此问题有两种方法法一就是将他们排序，然后比较两个字符串是否相等
方法二：时间换空间也就是桶记录他们每个字符的个数以及是否存在来确定 /
 */
public class Str5StringCombie {
    @Test
    public void test(){
        String s1 = "aaaabc";
        String s2 = "abcaaa";
        compareMethod1(s1,s2);
        compareMethod2(s1,s2);
    }

    public static void compareMethod2(String s1, String s2){
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        int cCout[] = new int[256];//因为字符数一共256个，所以足够了
        for (int i = 0; i < 256; i++) {
            cCout[i] = 0;
        }
        for (int i = 0; i < b1.length; i++) {
            cCout[b1[i] - '0']++;
        }
        for (int i = 0; i < b2.length; i++) {
            cCout[b1[i] - '0']--;
        }
        for (int i = 0; i < 256; i++) {
            if (cCout[i]!=0){
                System.out.println("not euqal 2");
                return;
            }
        }
        System.out.println("euqal 2");
    }
    public static void compareMethod1(String a,String b){
        byte[] b1 = a.getBytes();
        byte[] b2 = a.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        a = new String(b1);
        b = new String(b2);
        if(a.equals(b)){
            System.out.println("equal!");
        }else {
            System.out.println("not equal!");
        }
    }
}
