package SixFive.FindContinuousSequence41;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
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
        用两个数small、big分别表示序列的最小值和最大值，首先把small初始为1，big初始为2，如果small到big的和大于s,
        就从序列中去掉最小的值，也就是增大small的值，如果small到big的和小于s，那么就增大big的值，又因为序列至少2个数，
        所以small小于（s+1)/2。寻找small和big之间的序列和看是否满足条件即可。
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(  );
        if (sum < 3)
            return arrayLists;
        int small = 1;
        int big = 2;
        int mid = (sum+1)/2;
        int curSum = small + big;
        while (small<mid){
            ArrayList<Integer> list = new ArrayList<>(  );
            if (curSum==sum){
                for (int i = small ; i <= big; i++) {
                    list.add( i );
                }
                arrayLists.add( list );
            }
            while (curSum > sum && small < mid){
                curSum = curSum - small;
                small++;
                if (curSum==sum){
                    for (int i = small ; i <= big; i++) {
                        list.add( i );
                    }
                    arrayLists.add( list );
                }

            }
            big++;
            curSum += big;
        }
        return arrayLists;

    }

}