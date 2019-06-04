package wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/2
 * @time 20:41
 * @Description
 * 砸金蛋，一个int数组代表每个金蛋的价值，每次砸一个金蛋i,获得arr[i-1]*arr[i]*arr[i+1]的奖励，并将假设a[-1]=a[n]=1,求奖励最大的砸法
 * 关键点：类似于最小矩阵链的计算次数，想办法把问题分为两个子问题。在这里假设最后一次砸的为金蛋i，则最后一次奖励为1*i*1，所以可以给金蛋链两边加上1，但这两个金蛋不能砸。
 * 而且此时问题划分为砸从i分开的两个金蛋链的砸法，而且这两个金蛋链最后一次砸的时候右边界和左边界都为i，也是不能砸。
 * 遇到这种一个数组，相邻的计算，然后数组缩小问题，这种考虑找出关键点，把问题分为两个子链。
 */
public class _4 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6} ;
        System.out.println(memo(array));
        System.out.println(findMax(array));
    }
    private static int findMax(int[] array){
        if(array.length==0){
            return 0 ;
        }
        if(array.length==1){
            return array[0] ;
        }
        if(array.length==2){
            return array[0]*array[1]+Math.max(array[1],array[0]) ;
        }
        int max = -1 ;
        for(int i=0;i<array.length;i++){
            if(i==0){
                int tmp = 1*array[i]*array[1] ;
                int[] newArray = new int[array.length-1] ;
                System.arraycopy(array, 1, newArray, 0, newArray.length) ;
                int max1 = findMax(newArray);
                max = Math.max(tmp+max1,max) ;
                newArray = null ;
            }else if(i==array.length-1){
                int tmp = 1*array[i]*array[1] ;
                int[] newArray = new int[array.length-1] ;
                System.arraycopy(array, 0, newArray, 0, newArray.length) ;
                int max1 = findMax(newArray);
                max = Math.max(tmp+max1,max) ;
                newArray = null ;
            }else {
                int tmp = array[i-1]*array[i]*array[i+1] ;
                int[] newArray = new int[array.length-1] ;
                System.arraycopy(array, 0, newArray, 0, i) ;
                System.arraycopy(array, i+1, newArray, i, newArray.length-i) ;
                int max1 = findMax(newArray);
                max = Math.max(tmp+max1,max) ;
                newArray = null ;
            }
        }
        return max ;
    }
    private static int memo(int[] array){
        int[][]memo = new int[array.length+2][array.length+2] ;
        int len = array.length ;
        //构造新数组，数组边界用1围起来，表示最后一次砸的时候为1*i*1，这样最后边界的金蛋不可以砸
        int[] newArray = new int[len+2] ;
        newArray[0]=1;
        System.arraycopy(array,0,newArray,1,len);
        newArray[len+2-1] = 1 ;

        //初始化备忘录
        for(int i=0;i<len+2-1;i++){
            memo[i][i] = 0 ;
            memo[i][i+1] = 0 ;
        }
        memo[len+2-1][len+2-1] = 0 ;

        for(int l=3;l<=len+2;l++){ //不同长度的金蛋链
            for(int i=0;i<len+2-l+1;i++){//金蛋链的起始序号
                int max = Integer.MIN_VALUE ;
                for(int j=i+1;j<i+l-1;j++){ //金蛋链最后一个砸的序号，因为边界加上去的，或者说边界是用来给上一级的最后一个砸的，所以这次不可以砸
                    max = Math.max(max,newArray[i]*newArray[j]*newArray[i+l-1]+memo[i][j]+memo[j][i+l-1]) ;
                }
                memo[i][i+l-1] = max ;
            }
        }
        return memo[0][len+2-1] ;
    }
}
