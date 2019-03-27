package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/7
 * @time 17:32
 * @Description
 */
public class MatrixChainMultipication {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3} ;
//        System.out.println(mcm1(arr, 0, 4));
        System.out.println(mcm(arr,4));
    }
    public static int  mcm(int[] p,int n){
        int[][] tabu = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            tabu[i][i] = 0 ;
        }
        for(int L = 2;L<=n;L++){
            //从最短矩阵链开始

            for(int i=1;i<=n-L+1;i++){
                //遍历矩阵链的起始矩阵编号

                //初始化该矩阵链最小值为Int_MAX
                tabu[i][i+L-1] = Integer.MAX_VALUE ;
                for(int j=i;j<i+L-1;j++){
                    //遍历不同划分求得的最小值，若小于当前最小则更新
                    int tmp = tabu[i][j]+tabu[j+1][i+L-1]+p[i-1]*p[j]*p[i+L-1] ;
                    if(tabu[i][i+L-1]>tmp){
                        tabu[i][i+L-1] = tmp ;
                    }
                }
            }
        }
        return tabu[1][n] ;
    }

    public static int mcm1(int[] p,int begin,int end){
        if(end-begin<2){
            return 0 ;
        }
        int result = Integer.MAX_VALUE ;
        for(int i=1;i<end-begin;i++){
            int tmp = mcm1(p,begin,begin+i)+mcm1(p,begin+i,end)+p[begin]*p[begin+i]*p[end] ;
            if(tmp<result){
                result = tmp ;
            }
        }
        return result ;
    }
}
