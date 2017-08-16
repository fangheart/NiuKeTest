package leetcode.LEET2;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
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
    @Test
    public void test(){
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i<tokens.length;i++){
            try{
                    int num = Integer.parseInt(tokens[i]);
                    stack.add(num);
            }catch (Exception e) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.add(get(a, b, tokens[i]));
            }
    }
    return stack.pop();
}
private int get(int a,int b,String operator){
    switch (operator) {
    case "+":
        return a+b;
    case "-":
        return a-b;
    case "*":
        return a*b;
    case "/":
        return a/b;
    default:
        return 0;
    }
}

}