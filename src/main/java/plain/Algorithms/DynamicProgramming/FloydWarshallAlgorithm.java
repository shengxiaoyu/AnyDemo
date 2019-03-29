package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/14
 * @time 10:40
 * @Description
 */
public class FloydWarshallAlgorithm {

    /**
     * 动态规划Floyd算法
     * 设图G中n 个顶点的编号为1到n。令c [i, j, k]表示从i 到j 的最短路径的长度，其中k 表示该路径中的最大顶点，也就是说c[i,j,k]这条最
     * 短路径所通过的中间顶点最大不超过k。因此，如果G中包含边<i, j>，则c[i, j, 0] =边<i, j> 的长度；若i= j ，则c[i,j,0]=0；如果G中不
     * 包含边<i, j>，则c (i, j, 0)= +∞。c[i, j, n] 则是从i 到j 的最短路径的长度。对于任意的k>0，通过分析可以得到：中间顶点不超过k
     * 的i 到j 的最短路径有两种可能：该路径含或不含中间顶点k。若不含，则该路径长度应为c[i, j, k-1]，否则长度为
     * c[i, k, k-1] +c [k, j, k-1]。c[i, j, k]可取两者中的最小值。状态转移方程：
     * c[i, j, k]=min{c[i, j, k-1], c [i, k, k-1]+c [k, j, k-1]}，k＞0
     */
    public static int[][] floyd(int[][] dis,int n){
        int[][] result = new int[n][n];
        //记录路径
        int[][] path = new int[n][n] ;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j] = dis[i][j] ;
                if(dis[i][j]!=-1){
                    path[i][j]=i ;
                }else {
                    path[i][j]=-1 ;
                }
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(result[i][k]!=-1&&result[k][j]!=-1
                            &&result[i][k]+result[k][j]<result[i][j]){
                        result[i][j] = result[i][k]+result[j][j] ;
                        path[i][j]=k ;
                    }
                }
            }
        }
        return result ;
    }
}
