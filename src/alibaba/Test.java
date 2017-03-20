package alibaba;

/**
 * Created by FangHeart on 2017/3/18.
 */
/* 原理: 将测试点的Y坐标与多边形的每一个点进行比较，
**       会得到测试点所在的y行与多边形边的所有交点。
**       如果测试点的两边点的个数都是奇数个，
**       则该测试点在多边形内，否则在多边形外。 */


public class Test {
    public static class Point{
        int x;
        int y;
        public Point(){

        }
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Point p[] = new Point[3];
        p[0] = new Point(0,0);
        p[1] = new Point(1,2);
        p[2] = new Point(0,3);
        Point l = new Point(1,1);
        Point l2 = new Point(3,1);
        System.out.println(inOrNot(p,l2));
    }


    public static boolean inOrNot(Point[] p, Point l){
        boolean res = false;
        int j = p.length-1;
        for (int i = 0; i < p.length; i++) {
            if((p[i].y<l.y && p[j].y>=l.y || p[j].y<l.y && p[i].y>=l.y) && (p[i].x<=l.x || p[j].x<=l.x))
            {
                //相似三角形办法
                res ^= ((p[i].x + (l.y-p[i].y)/(p[j].y-p[i].y)*(p[j].x-p[i].x)) < l.x);
            }

            j=i;
        }
        return res;
    }
}
