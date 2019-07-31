package mianshiti.qq;


import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/5
 * @time 19:36
 * @Description
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;
        int s = in.nextInt() ;
        int[] v = new int[n] ;
        int index = 0 ;
        int total = 0 ; //总体积
        int min= Integer.MAX_VALUE ; //一开始最小体积
        while (in.hasNextInt()) {//注意while处理多个case
            v[index] = in.nextInt() ;
            total += v[index] ;
            min = Math.min(min,v[index]) ;
            index++ ;
        }
            //总体积小于s
        if(total<s){
            System.out.println(-1);
            return;
        }
        //喝完剩余总体积
        total = total-s ;
        if(total==0){
            System.out.println(0);
            return;
        }

        //喝完之后每瓶最多能剩余体积
        int mean = total/n ;

        if(mean<=min){
            System.out.println(mean);
        }else {
            System.out.println(min);
        }
    }
}
