package plain.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13314
 * @date 2019/7/28
 * @time 16:23
 * @Description
 */
public class _3 {
    // 本题为考试多行输入输出规范示例，无需提交，不计分。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt() ;
        int index = 0 ;
        int[] P = new int[n] ;
        while (index<n){
            P[index++] = sc.nextInt() ;
        }
        int[][] A = new int[n][n] ;
        index = 0 ;
        while (index<m){
            int x = sc.nextInt() ;
            int y = sc.nextInt() ;
            A[y][x] = 1 ;
        }

        //把不依赖于其他任务的，花费时间最少的任务执行
        int count = 0 ;
        StringBuilder sb = new StringBuilder() ;
        while (count<n){
            int min_time = Integer.MAX_VALUE ;
            int target = -1 ;
            for(int i=0;i<n;i++){
                boolean can = true ;
                for(int j=0;j<n;j++){
                    if(A[i][j]!=0){
                        can = false;
                        break;
                    }
                }
                if(can){
                    if(P[i]<min_time){
                        min_time = P[i] ;
                        target = i ;
                    }
                }
            }

            //执行第target项任务
            count++ ;
            if(sb.length()==0){
                sb.append(target) ;
            }else {
                sb.append(' ') ;
                sb.append(target) ;
            }
            //更新依赖项
            for(int i=0;i<n;i++){
                A[i][target] = 0 ;
            }
        }
        System.out.println(sb.toString());
    }

}
