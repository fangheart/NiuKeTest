package SixFive.Model;
import SixFive.NK52PatternMatch.Solution;
/**
 * Created by fangheart on 2017/4/10.
 */
public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();

        char[] str= {};
        char[] pattern = {'.','*'};

        System.out.println(str.length);
        System.out.print(solution.match(str,pattern));
    }
}
