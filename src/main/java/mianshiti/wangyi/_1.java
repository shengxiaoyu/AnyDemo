package mianshiti.wangyi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/4/2
 * @time 19:03
 * @Description
 */
public class _1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>(1000) ;
        String word = null ;
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            word = in.next() ;
            char[] chars = word.toCharArray() ;
            String newWord = "" ;
            String tmp = "" ;
            boolean isBegin = false ;
            for(char ch:chars){
                if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
                    tmp = tmp+ch ;
                }else {

                    newWord = ch+tmp+newWord ;
                    tmp = "" ;
                    isBegin = true ;
                }
            }
            if(isBegin){
                newWord = tmp+newWord ;
            }else {
                newWord = newWord+tmp ;
            }
            strs.add(newWord);
        }
        String result = "" ;
        Iterator<String> iterator = strs.iterator();
        while (iterator.hasNext()){
            word = iterator.next() ;
            result = " "+word+result ;
            iterator.remove();
        }
        result.substring(1,result.length()) ;
        System.out.println(result);

    }
}
