package SixFive.ArraySearch1;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public static void main(String[] args){

    }
    //思路一，每一行二分查找法
    //但是此方法时间复杂度为nlogn是在复杂度太大。
    public boolean Find2(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length-1;
            int mid = (low+high)/2;
            while(low<=high){
                if(target>array[i][mid]){
                    low = mid + 1;
                }else if(target<array[i][mid]){
                    high = mid - 1;
                }else
                    return true;
            }
        }
        return false;
    }

    //思路2，根据此数组的特性，
    /*
    * 链接：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
来源：牛客网

利用二维数组由上到下，由左到右递增的规律，
那么选取右上角或者左下角的元素a[row][col]与target进行比较，
当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,即col--；
当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,即row++；
    * */
    public boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length - 1;//选取右上角
        while(row<=array.length-1 && col>=0){
            if (target==array[row][col])
                return true;
            else if(target<array[row][col])
                col--;
            else
                row++;
        }
        return false;
    }
}