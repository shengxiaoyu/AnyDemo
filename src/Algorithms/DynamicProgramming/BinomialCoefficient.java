package Algorithms.DynamicProgramming;

/**
 * @author 13314409603@163.com
 * @date 2019/1/8
 * @time 22:51
 * @Description
 * Following are common definition of Binomial Coefficients.

A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects; more formally, the number of k-element subsets (or k-combinations) of an n-element set.
The Problem
Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 */
public class BinomialCoefficient {
    public static void main(String[] args) {
        System.out.println(bc(0, 0));
    }
    public static int bc(int n,int k){
        int[][] tabu = new int[n+1][k+1] ;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<k+1;j++){
                if(i==j||j==0) {
                    tabu[i][j] = 1;
                }else if(i==0||i<j){
                    tabu[i][j] = 0 ;
                }else {
                    tabu[i][j] = tabu[i-1][j]+tabu[i-1][j-1] ;
                }
            }
        }
        return tabu[n][k] ;
    }
}
