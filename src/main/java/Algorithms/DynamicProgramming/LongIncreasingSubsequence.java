package Algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * @author 13314409603@163.com
 * @date 2019/1/4
 * @time 18:53
 * @Description is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence
 * are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and
 * LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) + "\n" );
    }
    public static int lis(int[] arr,int n){
        int[] tabu = new int[n] ;
        Arrays.fill(tabu,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && tabu[j]+1>tabu[i]){
                    tabu[i] = tabu[j]+1 ;
                }
            }
        }
        int res = 0 ;
        for(int i=0;i<tabu.length;i++){
            if(res<tabu[i]){
                res = tabu[i] ;
            }
        }
        return res ;
    }
}
