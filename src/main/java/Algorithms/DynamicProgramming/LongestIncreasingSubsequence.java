package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2018/12/23
 * @time 16:30
 * @Description
 *  to find the length of the longest subsequence of a given sequence such that all elements of the subsequence
 *  are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
 *  and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6} ;
        System.out.println(f(arr));
    }
    public static int f(int [] arr){
        if(arr.length<2){
            return arr.length ;
        }
        int[] result = new int[arr.length+1] ;
        for(int i=1;i<arr.length+1;i++){
            result[i] = 1 ;
            for(int j=1;j<i;j++){
                if(arr[j-1]<arr[i-1]){
                    result[i] = Math.max(result[i],1+result[j]) ;
                }
            }
        }
        int max = result[0] ;
        for(int tmp:result){
            if(tmp>max){
                max = tmp ;
            }
        }
        return max ;
    }
}
