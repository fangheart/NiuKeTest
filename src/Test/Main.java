package Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fangheart on 2017/4/26.
 */
public class Main {
    int n = 0;
    Stack<Integer> stack = new Stack<Integer>();
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c[] = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String d:
             c) {
            sb.append(d);
        }

    char cc[] = sb.toString().toCharArray();

        Main test = new Main();
       System.out.print( test.two(cc));
//        System.out.print(test.match(str.toCharArray(),patt.toCharArray()));
    }
    public  int two(char c[]){
        int i = 0;
        while (i<c.length) {

            if (c[i] >= '0' && c[i] <= '9') {
                stack.push(c[i]-'0');
                n++;
                if (n>16)
                    return -2;
            }else if (c[i]=='^'){
                if (stack.isEmpty())
                    return -1;
                int a = stack.pop();
                a++;
                stack.push(a);
            }
            else if (c[i]=='+'){
                if (stack.isEmpty())
                    return -1;
                int a = stack.pop();
                if (stack.isEmpty())
                    return -1;
                int b = stack.pop();
                int d = a + b;
                stack.push(d);
            }
            else if (c[i]=='*'){
                if (stack.isEmpty())
                    return -1;
                int a = stack.pop();
                if (stack.isEmpty())
                    return -1;
                int b = stack.pop();
                int d = a * b;
                stack.push(d);
            }
            i++;
        }
        return stack.pop();
    }

//    public int match(char[] str, char[] pattern) {
//        if (pattern==null || str==null)
//            return 0;
//        int strIndex = 0;
//        int patternIndex = 0;
//        Boolean b;
//        b = matchCore(str,strIndex,pattern,patternIndex);
//        if (b)
//            return 1;
//        else
//            return 0;
//    }
//
//    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
//        //有效性检查二者都到达尾部，匹配成功
//        if (str.length==strIndex && pattern.length==patternIndex) {
//            return true;
//        }
//        //pattern先到尾部匹配失败
//        if (strIndex!=str.length && patternIndex==pattern.length)
//            return false;
//
//        if ((strIndex!=str.length&&str[strIndex]==pattern[patternIndex])||
//                (strIndex!=str.length&&pattern[patternIndex]=='?')){
//            return matchCore(str,strIndex+1,pattern,patternIndex+1);
//        }
//        if (strIndex!=str.length&&pattern[patternIndex]=='*'){
//            return matchCore(str,strIndex+1,pattern,patternIndex+1)||
//                    matchCore(str,strIndex+1,pattern,patternIndex)||
//                    matchCore(str,strIndex,pattern,patternIndex+1);
//        }
//
//        return false;
 //   }
}
