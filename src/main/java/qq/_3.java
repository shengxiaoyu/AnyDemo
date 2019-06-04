package qq;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/5
 * @time 20:21
 * @Description
 */
public class _3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;
        int k = in.nextInt() ;
        System.out.println(res(new int[n], 0, new int[n], 0, 1, k, 2 * n));
    }
    private static int res(int[] N1,int index1,int[] N2,int index2,int current,int k,int last){
        if(current==last){
            return 0;
        }
        int[] newN1 = Arrays.copyOf(N1,N1.length) ;
        int[] newN2 = Arrays.copyOf(N2,N2.length) ;
        if(index1==index2){
            newN1[index1] = current ;
            newN2[index2] = current ;
            return res(newN1,index1+1,N2,index2,current+1,k,last)+res(N1,index1,newN2,index2+1,current+1,k,last) ;
        }else if(index1>index2){//数组1比较长
                int tmp = 0 ;
                if(Math.abs(current-N1[index2])>=k){//可以放在短的数组中
                    newN2[index2] = current ;
                    tmp += res(N1,index1,newN2,index2+1,current+1,k,last) ;
                }
                if(index1<N1.length-1){//还可以放在长的里面
                    newN1[index1] = current ;
                    tmp += res(newN1,index1+1,N2,index2,current+1,k,last) ;
                }
                return tmp ;
        }else {//数组2比较长
            int tmp = 0 ;
            if(Math.abs(current-N2[index1])>=k){//可以放在短的数组中
                newN1[index1] = current ;
                tmp += res(newN1,index1+1,N2,index2,current+1,k,last) ;
            }
            if(index2<N2.length-1){//还可以放在长的里面
                newN2[index2] = current ;
                tmp += res(N1,index1,newN2,index2+1,current+1,k,last) ;
            }
            return tmp ;
        }
    }
}
