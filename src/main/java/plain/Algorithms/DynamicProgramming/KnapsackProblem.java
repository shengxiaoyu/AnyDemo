package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/9
 * @time 9:29
 * @Description
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
 * respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that
 * sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or
 * don’t pick it (0-1 property).
 * 背包问题：
 * 关键点在于：每次是否将一个物品放入背包，f(n,m)=Max(f(n-weigth[m],m-1)+val[m],f(n,m-1))
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] value = {60,100,120} ;
        int[] weight = {10,20,30} ;
        int w = 50 ;
        System.out.println(recursive(value, weight, w, value.length-1));
        System.out.println(kp(value, weight, w));
    }
    public static int recursive (int[] value,int[] weight,int w,int index){
        if (index<0){
            return 0 ;
        }
        if(weight[index]<=w){
            return Math.max(recursive(value,weight,w-weight[index],index-1)+value[index],
                    recursive(value,weight,w,index-1)) ;
        }else {
            return recursive(value,weight,w,index-1) ;
        }
    }

    public static int kp(int[] value,int[] weight,int w){
        int[][] tabu = new int[w+1][value.length+1] ;
        for(int i=0;i<=w;i++){
            for(int j=0;j<=weight.length;j++){
                if(i==0||j==0){
                    tabu[i][j]=0 ;
                }else if(weight[j-1]<=i){
                    tabu[i][j]=Math.max(tabu[i-weight[j-1]][j-1]+value[j-1],tabu[i][j-1]) ;
                }else {
                    tabu[i][j]=tabu[i][j-1] ;
                }
            }
        }
        return tabu[w][value.length] ;
    }

}
