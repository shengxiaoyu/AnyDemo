package plain.Algorithms.JianZhiOffer;
/**
 * @author 13314409603@163.com
 * @date 2019/4/1
 * @time 20:18
 * @Description
 */
public class _11 {
    public static void main(String[] args) {
        System.out.println(new _11().NumberOf1(10));
    }
    public int NumberOf1(int n) {
        int num = 0 ;
        int times = 32 ;
        while(n!=0 && times>0){
            num += (n&1) ;
            n = n >> 1;
            times-- ;
        }
//        Math.pow()
        return num ;
    }
}
