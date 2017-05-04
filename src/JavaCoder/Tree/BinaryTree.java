package JavaCoder.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by fangheart on 2017/4/19.
 */
class Node {
    public int data;
    public Node left;
    public Node right;
    public int leftMaxDistance;
    public int rightMaxDistance;
    public  Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
/**
 * Created by fangheart on 2017/3/6.
 */
public class BinaryTree {
    private Node root;
    public void BinartTree(){
        root = null;
    }
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        int[] data = {2,8,7,4,9,3,1,6,7,5};
        binaryTree.buildTree(data);
        System.out.println("二叉树的先序遍历：");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrder2(binaryTree.root);
        System.out.println();
        System.out.println("二叉树的中序遍历：");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrder2(binaryTree.root);
        System.out.println();
        System.out.println("二叉树的后序遍历：");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder2(binaryTree.root);
        System.out.println();

        System.out.println("二叉树两个结点的最大距离：");
        binaryTree.FindMaxDistance(binaryTree.root);
        System.out.print(binaryTree.maxLen);
    }
    //将data插入到排序二叉树中
    public void insert(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while(true){//寻找插入位置
                parent = current;
                if (data < current.data){
                    current = current.left;
                    if (current==null){
                        parent.left = newNode;
                        return;
                    }
                }else {
                    current = current.right;
                    if (current==null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    //将数值插入构建二叉树
    public void buildTree(int[] data){
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }
    //中序遍历输出
    public void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }
    //中序遍历非递归版本
    public void inOrder2(Node localRoot){
        Stack<Node> stack = new Stack<Node>();
        while(localRoot!=null||!stack.isEmpty()){
            while (localRoot!=null){
                stack.push(localRoot);
                localRoot = localRoot.left;
            }
            localRoot = stack.pop();
            System.out.print(localRoot.data + " ");
            localRoot = localRoot.right;
        }
    }
    //先序遍历
    public void preOrder(Node localRoot){
        if(localRoot != null ){
            System.out.print(localRoot.data+" ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }
    //先序遍历非递归版本
    public void preOrder2(Node localRoot){
        Stack<Node> stack = new Stack<Node>();
        while(localRoot!=null||!stack.isEmpty()){
            while (localRoot!=null){
                System.out.print(localRoot.data + " ");
                stack.push(localRoot);
                localRoot = localRoot.left;
            }
            localRoot = stack.pop();
            localRoot = localRoot.right;
        }
    }

    //后续遍历
    public void postOrder(Node localRoot){
        if(localRoot != null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }
    //后序遍历非递归版本
    public void postOrder2(Node localRoot){
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> outStack = new Stack<Node>();//后续是左右中 那我们就按中右左的方式先存入栈里
        while(localRoot!=null||!stack.isEmpty()){
            while (localRoot!=null){
                outStack.push(localRoot);
                stack.push(localRoot);
                localRoot = localRoot.right;
            }
            localRoot = stack.pop();
            localRoot = localRoot.left;
        }
        while(!outStack.isEmpty()){
            localRoot = outStack.pop();
            System.out.print(localRoot.data + " ");
        }
    }

    //层序遍历
    //层序遍历的主要思路是将根节点放入队列，然后每次都从队列中取出一个节点打印，
    //如这个节点有子节点，则将子节点放入队列，直到队列为空
    public void layerTranverse() {
        if (this.root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(this.root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.data + " ");
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    int maxLen = 0;
        //二叉树结点的最大距离
    private void FindMaxDistance(Node root){
        if (root==null)
            return;
        if (root.left==null)
            root.leftMaxDistance = 0;
        if (root.right==null)
            root.rightMaxDistance = 0;
        if (root.left!=null)
            FindMaxDistance(root.left);
        if (root.right!=null)
            FindMaxDistance(root.right);

        //计算左子树距离根节点的最大距离
        if (root.left!=null)
            root.leftMaxDistance = max(root.left.leftMaxDistance,
                    root.left.rightMaxDistance)+1;
        //计算右子树距离根节点的最大距离
        if (root.right!=null)
            root.rightMaxDistance = max(root.right.leftMaxDistance,
                    root.right.rightMaxDistance)+1;
        //获取所有结点的最大距离
        if (root.leftMaxDistance+root.rightMaxDistance>maxLen){
            maxLen = root.leftMaxDistance+root.rightMaxDistance;
        }
        //return maxLen;
    }
    private static int max(int a, int b) {
        return a > b ? a : b;
    }

}
