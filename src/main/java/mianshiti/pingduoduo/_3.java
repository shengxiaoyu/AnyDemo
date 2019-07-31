package mianshiti.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/3
 * @time 18:57
 * @Description
 */
public class _3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;
        int[] ints = new int[n] ;
        int index = 0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            ints[index++] = in.nextInt();
        }
        Arrays.sort(ints);
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;
        for(int i=0;i<n/2;i++){
            int tmp = ints[i]+ints[n-1-i] ;
            max = Math.max(tmp,max) ;
            min = Math.min(tmp,min) ;
        }
        System.out.println(max-min);
    }
}
