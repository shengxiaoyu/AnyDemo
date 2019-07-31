package mianshiti.qq;

import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/5
 * @time 19:57
 * @Description
 */
public class _2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;
        int[] d = new int[n] ;
        int[] p = new int[n] ;
        int index = 0 ;
        while (in.hasNextInt() && index<n) {//注意while处理多个case
            d[index++] = in.nextInt() ;
        }
        index = 0;
        while (in.hasNextInt()){
            p[index++] = in.nextInt() ;
        }
        System.out.println(res(0,d,p,0));
    }

    private static int res(int D,int[]d,int[]p,int cousor){
        if(cousor==p.length){
            return 0 ;
        }
        if(D<d[cousor]){//当前武力值和小于怪兽
            return p[cousor]+res(D+d[cousor],d,p,cousor+1) ;
        }else {//当前武力值和大于怪兽，分两种情况讨论
            return Math.min(p[cousor]+res(D+d[cousor],d,p,cousor+1),res(D,d,p,cousor+1)) ;
        }
    }
}
