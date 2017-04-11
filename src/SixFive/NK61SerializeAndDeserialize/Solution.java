package SixFive.NK61SerializeAndDeserialize;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
请实现两个函数，分别用来序列化和反序列化二叉树
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
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer(  );
        if (root==null){
            stringBuffer.append( "#," );
            return stringBuffer.toString();
        }
        stringBuffer.append( root.val + "," );
        stringBuffer.append( Serialize( root.left ) );
        stringBuffer.append( Serialize( root.right ) );
        return stringBuffer.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index>=len)
            return null;
        String []strr = str.split( "," );
        TreeNode node = null;

        if (!strr[index].equals( "#" )){
            node = new TreeNode( Integer.valueOf( strr[index] ) );
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}