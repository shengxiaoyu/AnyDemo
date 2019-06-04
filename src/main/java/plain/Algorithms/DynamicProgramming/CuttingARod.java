package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/11
 * @time 18:18
 * @Description
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8
 * and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces
 * of lengths 2 and 6)
length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
 关键点：对于总长n，和每种切割长度的价格列表prices，也是考虑结果集中是否有第i中切割长度。f(n,m)=Max(f(n,m-1),f(n-m,m)+prices[m]) n>m

 思路二：总长n，不同切割点，f(n) = Max(f(1)+prices[m-1],f(2)+price[m-2],...,f(n))
 */
public class CuttingARod {
    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(car(arr, 8));
    }

    /**
     * 动态规划，当作无限版的背包问题
     * @param price
     * @param n
     * @return
     */
    public static int car(int[] price,int n){
        int[][] tabu = new int[n+1][price.length+1] ;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=price.length;j++){
                if(i==0||j==0){
                    tabu[i][j] = 0 ;
                }else {
                    if(j<=i){
                        tabu[i][j]=Math.max(tabu[i-j][j]+price[j-1],tabu[i][j-1]) ;
                    }else {
                        tabu[i][j]=tabu[i][j-1] ;
                    }
                }
            }
        }
        return tabu[n][price.length] ;
    }

    /**
     * 动态规划，划分问题，在不同位置划分
     * @param price
     * @param n
     * @return
     */
    public static int car2(int[] price,int n){
        int[] val = new int[n+1] ;
        val[0]=0 ;
        for(int i=1;i<=n;i++){
            //不同长度的rod

            int max_val = Integer.MIN_VALUE ;
            for(int j=0;j<i;j++){
                //不同位置划分
                max_val = Math.max(max_val,price[j]+val[i-j-1]) ;
            }
            val[i]=max_val ;
        }
        return val[n] ;
    }
}
