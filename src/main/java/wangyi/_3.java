package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/2
 * @time 19:27
 * @Description
 * 6 6
2 3 3 3 4 5
 */
public class _3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt() ;
        int W = in.nextInt() ;
        int[] weights = new int[num] ;
        int index = 0 ;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            weights[index++] = in.nextInt() ;
        }
        Arrays.sort(weights);
        System.out.println();
    }

}
