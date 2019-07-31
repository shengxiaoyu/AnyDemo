package mianshiti.wangyi;

import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/2
 * @time 19:21
 * @Description
 */
public class _2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt() ;
        int[] ints = new int[num] ;
        int index = 0 ;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            ints[index++] = in.nextInt() ;
        }
        int count = 0;
        for (int i=0;i<num;i++){
            for (int j=i+1;j<num;j++){
                for (int k=j+1;k<num;k++){
//                    if(ints[i])
                    if(!isTrue(ints[i],ints[j],ints[k])){
                        count++ ;
                    }
                }
            }
        }
        System.out.println(count);
    }
    private static boolean isTrue(int a,int b,int c){
        int mix = Math.min(a,b) ;
        mix = Math.min(mix,c) ;
        int divider = 2 ;
        while (divider<=mix/2){
            if(a%divider==0&&b%divider==0&&c%divider==0){
                return true ;
            }
            divider++ ;
        }
        return false ;
    }

}
