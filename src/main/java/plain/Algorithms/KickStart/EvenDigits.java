package plain.Algorithms.KickStart;

/**
 * @author 13314409603@163.com
 * @date 2019/6/13
 * @time 22:34
 * @Description Determine the minimum number of button presses to make with no odd digits.A button press
 * can increase the number by 1 or decrease the number by 1
 *  42-> 0
 *  11->3 (11-3=8)
 *  解题思路：如果一个数的数字里含有奇数，有两种方式可以变为全偶数：
 *  1、该位数加1，后面的数全部变为0。但此时要注意，如果发生进位，则必须保证更高位的还为偶数，需要加2
 *  2、该位数减1，后面的数全部变为8.
 *  比较两种方式得到的数字和原数字的差，取小的情况
 */
public class EvenDigits {
    public static int cal(int n){
        String str = String.valueOf(n) ;
        for(int i=0;i<str.length();i++){
            if((Integer.parseInt(str.charAt(i)+"")&1) == 1){
                return Math.min(findBigger(str,i)-n,n-findSmaller(str,i)) ;
            }
        }
        return 0 ;
    }
    private static int findBigger(String str,int index){

        String result_str = "" ;
        int the_index_number = Integer.parseInt(str.charAt(index)+"")+1 ;
        if(the_index_number==10) {
            result_str = "0" ;
            //判断上一个偶数字是否要加2
            boolean addTwo = true ;
            for (int i = index-1; i >= 0; i--) {
                if(addTwo){
                    int current_number = Integer.parseInt(str.charAt(i)+"")+2 ;
                    if(current_number==10){
                        result_str = "0" + result_str ;
                        addTwo = true ;
                    }else {
                        result_str = str.charAt(i)+result_str ;
                        addTwo = false ;
                    }
                }else{
                    result_str = str.charAt(i)+result_str ;
                }
            }
            if(addTwo){
                result_str = "2"+result_str ;
            }
        }else{
            for(int i=0;i<index;i++){
                result_str += str.charAt(i) ;
            }
            result_str += the_index_number ;
        }
        for(int i=index+1;i<str.length();i++){
            result_str += "0" ;
        }
        return Integer.parseInt(result_str) ;
    }
    private static int findSmaller(String str,int index){
        String result_str = "" ;
        for(int i=0;i<str.length();i++){
            if(i<index){
                result_str+=str.charAt(i) ;
            }else if(i==index){
                result_str += (Integer.parseInt(str.charAt(i)+"")-1) ;
            }else {
                result_str += "8" ;
            }
        }
        return Integer.parseInt(result_str) ;
    }

    public static void main(String[] args) {
        System.out.println(EvenDigits.cal(42));
        System.out.println(EvenDigits.cal(11));
        System.out.println(EvenDigits.cal(2018));
        System.out.println(EvenDigits.cal(1));
    }
}
