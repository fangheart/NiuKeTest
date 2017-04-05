package SixFive.NK35InversePairs;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
输入例子:
1,2,3,4,5,6,7,0
输出例子:
7
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
归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；
则前面数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     */
    int cnt = 0;
    public int InversePairs(int [] array) {
        if (array==null)
            return 0;
        mergesort(array,0,array.length-1);
        return cnt%1000000007;
    }

    public void mergesort(int[] array, int start, int end) {
        if (start>=end)
            return;
        int mid = start+(end-start)/2;
        mergesort(array,start,mid);
        mergesort(array,mid+1,end);

        merge(array,start,mid,end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int []tmp = new int[end-start+1];
        int i = start, j=mid+1,k=0;
        while (i<=mid&&j<=end){
            if (array[i]<array[j]){
                tmp[k++] = array[i++];
            }else {
                tmp[k++] = array[j++];
                cnt = cnt + mid - i + 1;
                //防止测试例过大
                if (cnt>1000000007)
                    cnt = cnt % 1000000007;
            }
        }
        while (i<=mid){
            tmp[k++] = array[i++];
        }
        while (j<=end){
            tmp[k++] = array[j++];
        }
        for (int l = 0; l < tmp.length ; l++) {
            array[start+l] = tmp[l];
        }
    }
}