package JavaCoder.String;

import org.junit.Test;

/**
 * Created by fangheart on 2017/4/19.
 */
/*
删除字符串中重复的字符如good应该变成god
此问题也有两种办法第一蛮力遍历把重复的先变为’\0’，再去掉
方法二空间换时间因为字符个数也是256，也可以根据记录个数去重(另提供更节省空间的法三)
 */
public class Str3RemoveDuplicate {
    @Test
    public void test(){
        System.out.println(removeDuplicate3("goooood"));
    }
    //方法三在方法二的基础上知道我们需要256大小的空间，每1bit记录一个字符是否存在，
    //更好的方案是我们申请一个大小为8的int型数组，每个int 32位，32x8=256
    public static String removeDuplicate3(String s){
        char c[] = s.toCharArray();
        int len = c.length;
        int flag[] = new int[8];

        for (int i = 0; i < 8; i++) {
            flag[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            int index = (int)c[i] / 32;
            int shift = (int)c[i] % 32;
            if ((flag[index]&(1<<shift))!=0){
                c[i] = '\0';
            }else {
                flag[index] |= 1<<shift;
            }
        }
        int l = 0;
        for (int i = 0; i < len; i++) {
            if (c[i]!='\0'){
                c[l++] = c[i];
            }
        }
        return new String(c,0,l);
    }
    //方法二空间换时间
    public static String removeDuplicate2(String s1){
        char[] c = s1.toCharArray();
        StringBuffer sb = new StringBuffer();
        int[] cCout = new int[256];
        //初始化都为0，如果后面的遇到为1那么说明前面已经存在
        for (int i = 0; i < 256; i++) {
            cCout[i] = 0;
        }
        for (int i = 0; i < c.length; i++) {
            if (cCout[c[i]] == 1){
                continue;
            }
            sb.append(c[i]);
            cCout[c[i]] = 1;
        }
        return sb.toString();
    }
    //方法一蛮力法
    public static String removeDuplicate1(String s1){
        char[] c = s1.toCharArray();
        //重复的数字置换为'\0'
        for (int i = 0; i < c.length; i++) {
            for (int j = i+1; j < c.length; j++) {
                if (c[i]==c[j]){
                    c[j]= '\0';
                }
            }
        }
        //去掉‘\0’
        int k=0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]!='\0'){
                c[k++] = c[i];
            }
        }
        return new String(c,0,k);
    }
}
