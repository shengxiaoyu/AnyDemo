package plain.pingduoduo;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author 13314
 * @date 2019/7/28
 * @time 14:59
 * @Description
 */
public class _1 {
    public static void main(String[] args) {
        int[] A = {1,3 ,7 ,4, 10} ;
        int[] B = {2 ,1 ,5 ,8 ,9} ;

        //找出特殊数字
        int index = -1 ;
        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                index = i ;
            }
        }
        if(index==-1){
            System.out.println("NO");
            return;
        }

        //找出B中满足的最大值
        int max = Integer.MIN_VALUE ;
        for(int i=0;i<B.length;i++){
            if(index-1>=0&&B[i]>A[index-1]){
                if(index+1<A.length&&B[i]<A[index+1]){
                    if(B[i]>max){
                        max = B[i] ;
                    }
                }
            }
        }
        if(max==Integer.MIN_VALUE){
            System.out.println("NO");
        }else {
            A[index] = max ;
            for(int i:A){
                System.out.print(i+" ");
            }
        }
    }
}
