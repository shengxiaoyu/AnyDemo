package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/7
 * @time 16:13
 * @Description
 *
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {
    public static void main(String[] args) {
        int arr[] = {1,2,3} ;
//        System.out.println(cc(4,arr));
        System.out.println(count(arr,3,4));
    }

    public static int cc(int N,int[] S){
        int[][] tabu = new int[N+1][S.length+1] ;
        for(int i=0;i<=N;i++){
            for(int j=1;j<=S.length;j++){
                if(i==0) {
                    tabu[i][j] = 1;
                }else if(j==1){
                    tabu[i][j] = 1 ;
                }else {
                    tabu[i][j]=tabu[i][j-1] ;
                    if(i>=S[j-1]){
                        tabu[i][j]= tabu[i][j]+tabu[i-S[j-1]][j] ;
                    }
                }
            }
        }
        return tabu[N][S.length] ;
    }
    public static int cc2(int S[],int m,int  n){
        int table[] = new int[n+1];
        table[0] = 1 ;
        for(int i =0;i<m;i++){
            for(int j=S[i];j<=n;j++){
                table[j] += table[j-S[i]] ;
            }
        }
        return table[n] ;
    }
    public static int count(int S[],int m,int n){
        if (n == 0) {
            return 1;
        }

        // If n is less than 0 then no
        // solution exists
        if (n < 0) {
            return 0;
        }

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <=0 && n >= 1) {
            return 0;
        }

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) +
                count( S, m, n-S[m-1] );
    }

}
