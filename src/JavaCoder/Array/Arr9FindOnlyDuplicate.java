package JavaCoder.Array;

/**
 * Created by fangheart on 2017/4/19.
 */
/*
数组A[N],1~N-1这个N-1个数存在a[N]中，其中某个数字重复一次。
找出数组中唯一重复的元素
要求每个数只能访问一次并且不用辅助空间
 */
public class Arr9FindOnlyDuplicate {

    //方法一累加求和法因为只有一个数重复累加后减去1~N-1的和就是结果
    public static int findDup1(int[] a){
        int n = a.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n-1; i++) {
            sum1 += a[i];
            sum2 += (i+1);
        }
        sum1 = sum1 + a[n-1];
        int result = sum1 - sum2;
        return result;
    }

}
