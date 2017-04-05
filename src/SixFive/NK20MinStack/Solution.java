package SixFive.NK20MinStack;

import java.util.Stack;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
注意不能有具体的int类型

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
    Stack dataStack = new Stack();
    Stack minStack = new Stack();
    public static void main(String[] args){

    }
    /*
思路：
用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数
比如，data中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
   则min依次入栈，5,  4,  3，3,3, 3, 3, 1
     */
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        }else{
            if (node<(int)minStack.peek()){
                minStack.add(node);
            }else {
                minStack.add((int)minStack.peek());
            }
        }

    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return (int)dataStack.peek();

    }

    public int min() {
        return (int)minStack.peek();
    }
}