package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2018/12/23
 * @time 16:30
 * @Description
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
