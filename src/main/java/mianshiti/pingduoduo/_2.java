package mianshiti.pingduoduo;

import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/3
 * @time 18:57
 * @Description
 */
public class _2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int index = 0 ;
        int total = 0 ;
        int[] ints = new int[10] ;
        while (index<10) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            ints[index] = in.nextInt() ;
            total+=ints[index++] ;
        }
        int A = in.nextInt() ;
        int B = in.nextInt() ;
        if(A<=ints[0]||B<=ints[0]){
            System.out.println(0);
            return;
        }
        boolean isA = true ;

        index = 0 ;
        int[] newInts = new int[total] ;
        for(int i=0;i<ints.length;i++){
            for(int j=0;j<ints[i];j++){
                newInts[index++] = i ;
            }
        }

        String strA = "" ;
        String strB = "" ;
        for(int i=0;i<A+B;i++){
            if(newInts[i]==0){
                isA = !isA ;
                continue;
            }
            if(isA){
                strA+=newInts[i] ;
            }else {
                strB+=newInts[i] ;
            }
        }

        System.out.println(Integer.parseInt(strA)*Integer.parseInt(strB));
    }
}
