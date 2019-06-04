package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/11
 * @time 19:04
 * @Description
 *
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first
 * increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest
 * bitonic subsequence.
A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing
order sequence is considered Bitonic with the increasing part as empty.
    关键点：相当于最长（递增序列+递减序列），分情况考虑将任意一点作为转折点，左边为递增，右边递减
 */
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        int arr2[] = {80, 60, 30, 40, 20, 10};
        System.out.println(lbs(arr));
    }
    public static int lbs(int[] arr){
        int n = arr.length ;
        int[] desc = new int[n] ;
        int[] incr = new int[n] ;

        incr[0]=1;
        for(int i=1;i<n;i++){
            incr[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    incr[i] = Math.max(incr[i],1+incr[j]) ;
                }
            }
        }
        desc[n-1]=1;
        for(int i=n-2;i>-1;i--){
            desc[i]=1 ;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    desc[i]=Math.max(desc[i],1+desc[j]) ;
                }
            }
        }
        int max = Integer.MIN_VALUE ;
        for(int i=0;i<n;i++){
            max = Math.max(desc[i]+incr[i]-1,max) ;
        }
        return max ;
    }
}
