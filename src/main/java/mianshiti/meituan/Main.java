package mianshiti.meituan;

import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/23
 * @time 20:09
 * @Description:
 * 我们称一个矩阵为黑白矩阵，当且仅当对于该矩阵中每一个位置如(i,j),其上下左右四个方向的数字相等，即(i-1,j),(i+1,j),(i,j+1),(i,j-1)四个位置上的数字两两相等且均不等于(i,j)位置上的数字。(超出边界的格子忽略)

    现在给出一个n*m的矩阵，我们想通过修改其中的某些数字，使得该矩阵成为黑白矩阵，问最少修改多少个数字。
 */
public class Main {
    private static int count = 0 ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;
        int m = in.nextInt() ;
        int[][] nm = new int[n][m] ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nm[i][j] = in.nextInt() ;
            }
        }
        //第一个不变

    }
    private void check(int x,int y,int[][] mn,int n,int m){
        int current = mn[x][y] ;
        //right
        if(y+1<m){
            if(mn[x][y+1]==current){
                count++ ;
            }
        }
    }
}
