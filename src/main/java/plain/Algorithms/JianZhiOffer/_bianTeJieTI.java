package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314409603@163.com
 * @date 2019/3/31
 * @time 23:55
 * @Description
 */
public class _bianTeJieTI {
    public static void main(String[] args) {
        System.out.println(new _bianTeJieTI().JumpFloorII(4));
    }
    public int JumpFloorII(int target) {
        //存储台阶有i级，最大可以跳j级时的方法数
        int[][] memo = new int[target+1][target+1] ;

        for(int i=1;i<target+1;i++){
            for(int j=1;j<=i;j++){
                if(j==1){
                    memo[i][j]=1 ;
                    continue ;
                }
                int len = i ;
                //使用调j步的方法总数
                while(len>=j){
                    memo[i][j] += memo[len-j][j-1] ;
                    len -= j;
                }
                //不适用跳j步的方法总数
                memo[i][j] += memo[i][j-1] ;
            }
        }
        return memo[target][target] ;
    }
}
