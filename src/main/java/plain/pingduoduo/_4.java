package plain.pingduoduo;

import java.util.Scanner;

/**
 * @author 13314
 * @date 2019/7/28
 * @time 15:54
 * @Description
 */
public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] L = new Integer[n] ;
        int index = 0;
        while(index<n){
            L[index++] = sc.nextInt() ;
        }
        Integer[] W = new Integer[n] ;
        index = 0 ;
        while(index<n){
            W[index++] = sc.nextInt() ;
        }


        int[] hights = new int[n] ;
        int[] weights = new int[n] ;
        hights[0] = 1 ;
        weights[0] = W[0] ;

        int res = 0 ;

        for(int i=1;i<n;i++){
            int max_hight = 1 ;
            int max_weight = W[i] ;
            for(int j=0;j<i;j++){
                if(L[i]>L[j]){
                    //长度严格递增
                    if(W[i]*7>=weights[j]){
                        //判断负重是否满足
                        if(hights[j]+1>max_hight){
                            max_hight = Math.max(max_hight,hights[j]+1) ;
                            max_weight = weights[j]+W[i] ;
                        }
                    }
                }
            }
            hights[i] = max_hight ;
            weights[i] = max_weight ;
            res = Math.max(res,hights[i]) ;
        }
        System.out.println(res);
    }
}
