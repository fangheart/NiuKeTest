package JavaCoder.String;

import org.junit.Test;

/**
 * Created by fangheart on 2017/4/19.
 */
public class Str7KMPStringHasSubString {

    @Test
    public void test(){
        System.out.println(KMP("goooooodgodddddd","god"));
    }
    public static boolean KMP(String str,String subStr){
        String newStr = "x" + str;
        String newSubStr = "x" + subStr;

        int i = 1;
        int j = 1;

        int []K = calK(subStr);

        while (i<=str.length()&&j<=subStr.length()){
            if (j==0||newStr.charAt(i)==newSubStr.charAt(j)){
                i++;
                j++;
            }else {
                j = K[j];
            }
        }
        if (j>subStr.length())
            return true;
        else
            return false;
    }
    public static int[] calK(String subString){
        String newSubStr = "x" + subString;
        int K[] = new int[newSubStr.length()];

        int i = 1;
        K[1] = 0;
        int j = 0;
        while (i<subString.length()){
            if (j==0||newSubStr.charAt(i)==newSubStr.charAt(j)){
                i++;
                j++;
                K[i] = j;
            }else {
                j = K[j];
            }
        }
        return K;
    }
}
