package plain.Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/11
 * @time 18:58
 * @Description
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that
 * the integers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output
 * should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input
 * array is {10, 5, 4, 3}, then output should be 10
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(msis(arr));
    }
    public static int msis(int[] arr){
        int[] sum = new int[arr.length];
        int result = Integer.MIN_VALUE ;
        sum[0] = arr[0] ;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    sum[i] = Math.max(sum[i],arr[i]+sum[j]) ;
                }
            }
            result = Math.max(result,sum[i]) ;
        }
        return result ;
    }
}
