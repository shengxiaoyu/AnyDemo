package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/4
 * @time 20:14
 * @Description
 */
public class MinCostPath {
    public static void main(String[] args) {
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println(mcp(cost,2,2));
    }
    public static int mcp(int[][] cost,int m,int n){
        int[][] tabu = new int[m+1][n+1] ;
        for(int i=0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0&&j==0){
                    tabu[i][j] = cost[0][0] ;
                    continue;
                }
                if(i==0&&j!=0){
                    tabu[i][j] = tabu[i][j-1]+cost[i][j] ;
                    continue;
                }
                if(j==0&&i!=0){
                    tabu[i][j] = tabu[i-1][j]+cost[j][i];
                    continue;
                }
                tabu[i][j] = Math.min(tabu[i-1][j]+cost[i][j],Math.min(tabu[i-1][j-1]+cost[i][j],tabu[i][j-1]+cost[i][j])) ;
            }
        }
        return tabu[m][n] ;
    }
}
