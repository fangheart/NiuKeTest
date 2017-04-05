package SixFive.NK44ReverseSentence;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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