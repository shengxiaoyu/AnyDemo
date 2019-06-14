package plain.Algorithms.KickStart;

import java.util.Arrays;

/**
 * @author 13314409603@163.com
 * @date 2019/6/14
 * @time 19:54
 * @Description there is a bag with N items. The i-th item in the bag has value Vi . You will put your hand into the bag
 * and draw one item at random; all items in the bag have an equal probability of being chosen .
 * you may only redip a maximum of K times
 * play optimally to maximize the value of the item you will end the game with, what is the expected value of that item?
 * 4 0
 * 1 2 3 4 => 2.5
 *
 * 3 1
 * 1 10 1 =>6
 *
 * 一种变异的背包问题。有递推方式：如果可抽取次数为N，期望为E(N),那么比可抽取次数为N-1时多了一次选择的机会。我们可以看作第一次抽取的时候，如果抽取出来的数比E(N-1)小，那么我们
 * 肯定要放回重新抽，毕竟我后面的期望大，很可能抽到的结果比现在的大。如果抽取出来的数比E(N-1)大，那么则直接结束，因为后面再抽，期望只有E(N-1)，很可能比现在更小。
 *
 **/
public class LuckyDip {
    public static void main(String[] args) {
        System.out.println(LuckyDip.cal(4, 0, new int[]{1, 2, 3, 4}));
        System.out.println(LuckyDip.cal(3, 1, new int[]{1, 10, 1}));
    }
   public static double cal(int n,int k,int[] value){
       //先对数组排序,递增
       Arrays.sort(value);
       //求前缀和
       int[] sum = new int[n+1] ;
       for(int i=n-1;i>=0;i--){
           sum[i] = sum[i+1]+value[i] ;
       }
       //存储不同K值的期望
       double[] e = new double[k+1] ;
       e[0] = sum[0]*1.0/n ;
       for(int i=1;i<=k;i++){
           //先找到比上一个期望小的临界值
           int index = 0 ;
           for(int j=0;j<n;j++){
               if(value[j]>e[i-1]){
                   index = j ;
                   break;
               }
           }
           e[i] = (sum[index]+index*e[i-1])/n ;
       }
       return e[k];
   }
}
