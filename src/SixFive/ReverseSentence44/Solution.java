package SixFive.ReverseSentence44;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*

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

     */
    public String ReverseSentence(String str) {
        char[] cArr = str.toCharArray();
        //对整个字符串进行字符翻转
        swap(cArr, 0, cArr.length - 1);
        int begin = 0;
        //对每个单词进行字符串翻转操作
        for (int i = 1; i < cArr.length; i++){
            if (cArr[i]==' '){
                swap(cArr,begin,i-1);
                begin = i+1;
            }
        }
        swap(cArr,begin,cArr.length-1);
        return new String(cArr);
    }
    public static void swap(char[] cArr,int front,int end){
        while(front < end){
            char tmp = cArr[end];
            cArr[end] = cArr[front];
            cArr[front] = tmp;
            front++;
            end--;
        }
    }
}