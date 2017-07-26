package NiuKeMoNi5;

import java.util.Scanner;

/**
 * Created by fangheart on 2017/7/25.
 */
/*
牛牛和羊羊在玩一个有趣的猜数游戏。在这个游戏中,牛牛玩家选择一个正整数,羊羊根据已给的提示猜这个数字。第i个提示是"Y"或者"N",表示牛牛选择的数是否是i的倍数。
例如,如果提示是"YYNYY",它表示这个数使1,2,4,5的倍数,但不是3的倍数。
注意到一些提示会出现错误。例如: 提示"NYYY"是错误的,因为所有的整数都是1的倍数,所以起始元素肯定不会是"N"。此外,例如"YNNY"的提示也是错误的,因为结果不可能是4的倍数但不是2的倍数。
现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
例如 n = 5:
合法的提示有:
YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
所以输出12
输入描述:
输入包括一个整数n(1 ≤ n ≤ 10^6),表示已给提示的长度。


输出描述:
输出一个整数,表示合法的提示个数。因为答案可能会很大,所以输出对于1000000007的模

输入例子1:
5

输出例子1:
12
-----------

猜数游戏


	分析


	仔细分析我们可以发现一个位置是Y还是N依赖于他的倍数。
考虑若干个素数p0,p1,p2...p3,当他们的乘积那个数确定为Y,那么它们一定也是Y。


	例如：
如果27是Y,那么9一定是Y,3也一定是Y,但是81可以是Y或者N。


	由于每个数都可以分解为若干素数的乘积。于是我们考虑范围内的素数及其k次幂的位置的情况,其他数字都可以由这些组合而来。
例如：n = 64 考虑2的次幂：
如果64是Y,那么32 16 8 4 2都要是Y;
如果64是N,32是Y,16 8 4 2都要是Y;
如果64 32是N，16是Y，8 4 2都要是Y;
...
依次类推一共有7种情况(因为64 = 2^6)
那么问题就变成计算每个素数p_i^(maxexp) <= n,然后情况数就是每个(maxexp + 1)的乘积
一个合法的YN序列对应一个数字，所以这题可以转换为一个长为n的YN序列表示的数字的个数。 得到每个素数的最大个数后，0,1，2，...，maxexp加起来一共maxexp+1个，所以这边是maxexp+1的乘积
 */
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int maxn = 1000000005;
        int mod = 1000000007;

        int[] vis = new int[n+1];

        long ans = 1;

        for (int i = 2; i <= n; i++) {
            if (vis[i]==1)
                continue;
            for (int j = i+i; j <=n ; j=j+i) {
                vis[j]=1;
            }
            int tmp = n;
            int cnt = 0;

            while (tmp>=i){
                tmp = tmp/i;
                cnt++;
            }

            ans = ans*(cnt+1)%mod;
        }

        System.out.println(ans);

    }

}
