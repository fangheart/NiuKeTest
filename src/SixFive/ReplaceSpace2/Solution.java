package SixFive.ReplaceSpace2;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
请实现一个函数，将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    public static void main(String[] args){

    }
    public String replaceSpace(StringBuffer str) {
        char[] c = str.toString().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            if (c[i]==' '){
                sb.append("%20");
            }else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}