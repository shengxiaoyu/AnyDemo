package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2018/12/23
 * @time 14:56
 * @Description
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 *  Given a number n, the task is to find n’th Ugly number.
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(UglyNumber.cal(150));
    }
    public static int cal(int n){
        int[] memo = new int[n] ;
        memo[0] = 1;
        int i2 = 0 ;
        int i3 = 0 ;
        int i5= 0 ;
        int i = 1;
        int q = -1 ;
        while(i<n){
            q = Math.min(Math.min(memo[i2]*2,memo[i3]*3),memo[i5]*5) ;
            memo[i++] = q;
            if(q==memo[i2]*2){
                i2++ ;
            }
            if(q==memo[i3]*3){
                i3++;
            }
            if(q==memo[i5]*5){
                i5++ ;
            }
        }
        return memo[n-1] ;
    }
}
