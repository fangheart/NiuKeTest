package SixFive.NK51multiplyArray;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args){

    }
    /*
B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
由此可知B[i]可拆分成两部分，一部分为
C[i]=A[0]*A[1]*...*A[i-1];
D[i]=A[i+1]*...*A[n-1]。

B0    1  A1  A2  ...  An-2  An-1
B1    A0 1   A2  ...  An-2  An-1
B2    A0 A1  1   ...  An-2  An-1
...   A0 A1  ...  1   An-2  An-1
Bn-2  A0 A1  A2  ...   1    An-1
Bn-1  A0 A1  Aw  ...  An-2   1


又根据C[i]和D[i]的特性可以得知。
C[i]=C[i-1]*A[i-1]; //左下角部分
D[i]=D[i+1]*A[i+1]; //右上角部分
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        int forward[] = new int[len];
        int backward[] = new int[len];
        int B[] = new int[len];

        forward[0] = 1;
        backward[len-1] = 1;

        //下三角求C
        for (int i = 1 ; i < len; i++) {
            forward[i] = forward[i-1]*A[i-1];
        }

        //上三角求D
        for (int i = len-2; i>=0; i--) {
            backward[i] = backward[i+1]*A[i+1];
        }

        for (int i = 0; i < len; i++) {
            B[i] = forward[i] * backward[i];
        }

        return B;
    }
}