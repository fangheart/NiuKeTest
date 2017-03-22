package SixFive.MinStack20;

import java.util.Stack;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
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