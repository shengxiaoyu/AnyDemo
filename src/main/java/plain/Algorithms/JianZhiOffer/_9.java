package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314409603@163.com
 * @date 2019/3/31
 * @time 23:55
 * @Description
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class _9 {
    public static void main(String[] args) {
        System.out.println(new _9().JumpFloorII(3));
    }
    public int JumpFloorII(int target) {
        //存储台阶有i级，最大可以跳j级时的方法数
        int[][] memo = new int[target+1][target+1] ;
        for(int i=0;i<target+1;i++){//台阶数
            for(int j=1;j<target+1;j++){//一次最多能跳几阶
                if(i==1 || i==0){
                    memo[i][j]=1 ;
                    continue ;
                }
                if(j>i){
                    memo[i][j]=memo[i][i]  ;
                    continue ;
                }
                //最后一次怎么跳的
                for(int k=1;k<=j&&k<=i;k++){
                    memo[i][j]+=memo[i-k][j] ;
                }
            }
        }
        return memo[target][target] ;
    }
    //可以推到出公式fn = 2*fn-1 n>1
    public int JumpFloor(int target){
        if(target==1){
            return 1 ;
        }
        else{
            return 2*JumpFloor(target-1) ;
        }
    }
}
