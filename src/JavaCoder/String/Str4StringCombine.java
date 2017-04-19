package JavaCoder.String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by fangheart on 2017/4/19.
 */
/*
求例如输入字符串abc，那么a、b、c三个字符共有多少种组合（假设字符串中所有字符都不重复）
a、b、c、ab、ac、bc、abc
此题我们就不考虑暴力的解法了
//方法一：递归
//方法二：用二进制数来表示字符的出现与不出现如011代表bc,111代表abc,100代表a /
 */
public class Str4StringCombine {
    @Test
    public void test(){
        String s = "abc";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer("");
        int len = c.length;
        for (int i = 1; i <= len; i++) {
            combineRecursiveImpl(c,0,i,sb);
        }
        System.out.println("-------------------------------");
        combine(c);
    }

    //方法二
    private static void combine(char[] c) {
        if (c==null)
            return;
        int len = c.length;
        boolean used[] = new boolean[len];
        char cache[] = new char[len];
        int result = len;
        while (true){
            int index = 0;
            while(used[index]){
                used[index] = false;
                ++result;
                if(++index==len)
                    return;
            }
            used[index] = true;
            cache[--result] = c[index];
            System.out.print(new String(cache).substring(result) + " " );
        }
    }
    private static void combineRecursiveImpl(char[] c, int begin, int len, StringBuffer sb) {
        if(len==0){
            System.out.println(sb+" ");
            return;
        }
        if (begin==c.length){
            return;
        }
        sb.append(c[begin]);
        combineRecursiveImpl(c,begin+1,len-1,sb);//取该字符的情况
        sb.deleteCharAt(sb.length()-1);
        combineRecursiveImpl(c,begin+1,len,sb);//不取该字符的情况
    }

    /*
    /
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。 /
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        if (str!=null && str.toCharArray().length>0){
            PermutationHelper(str.toCharArray(),0,hashSet);
        }
        arrayList.addAll(hashSet);
        Collections.sort(arrayList);
        return arrayList;
    }

    public void PermutationHelper(char[] chars, int i, HashSet<String> hashSet) {
        if (i==chars.length-1){
            hashSet.add(new String(chars));
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars,i,j);
                PermutationHelper(chars,i+1,hashSet);
                swap(chars,i,j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        if (i != j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
