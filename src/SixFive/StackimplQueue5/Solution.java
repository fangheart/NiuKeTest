package SixFive.StackimplQueue5;

import java.util.Stack;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
用两个栈实现一个队列的功能?要求给出算法和思路!
 <分析>：
  入队：将元素进栈A
  出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
  如果不为空，栈B直接出栈。
  用两个队列实现一个栈的功能?要求给出算法和思路!
  <分析>：
  入栈：将元素进队列A
  出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素以此出队列并放入队列B，
  直到队列A中的元素留下一个，然后队列A出队列，再把队列B中的元素出队列以此放入队列A中。
 */
public class Solution {
    public static void main(String[] args){

    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int a;
        if (stack2.empty()){
            while (!stack1.empty()){
                a = stack1.pop();
                stack2.push(a);
            }
        }
        a = stack2.pop();
        return a;
    }
}