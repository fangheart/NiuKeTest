package SixFive.NK64maxInWindows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
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
队列序可以从两端删除元素，因此使用双端队列。
 *     原则： *     对新来的元素k，将其与双端队列中的元素相比较
 *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *     队列的第一个元素是滑动窗口中的最大值
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>(  );
        if (size==0)
            return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>(  );
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty())
                q.add( i );
            else if (begin>q.peekFirst())
                q.pollFirst();//清除前端过期不在滑动窗口内的元素

            while ((!q.isEmpty()) && num[q.peekLast()]<=num[i])
                q.pollLast();  //去掉前面小于后面值的前端元素，因为前面值不可能是滑动窗口的最大元素了
            q.add( i );//最大数下标加入队列
            if (begin>=0)
                res.add( num[q.peekFirst()] );
        }
        return res;
    }
    /*
 * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，
队列序可以从两端删除元素，因此使用双端队列。
 *     原则： *     对新来的元素k，将其与双端队列中的元素相比较
 *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *     队列的第一个元素是滑动窗口中的最大值
     */

public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }
        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }
}