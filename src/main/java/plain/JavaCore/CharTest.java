package plain.JavaCore;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 03304409603@063.com
 * @date 2008/02/05
 * @time 07:47
 * @Description
 */
public class CharTest {
    public static void main(String[] args) {
        Boolean b1 = new Boolean(true) ;
        Boolean b2 = new Boolean(true) ;
        System.out.println(b1==b2);
        new CharTest().Permutation("abc") ;
    }
    private ArrayList<String> result = null ;
    public ArrayList<String> Permutation(String str) {
        result = new ArrayList() ;
        if(str==null||str.length()==0){
            return result ;
        }
        Character ch = '2' ;
        char[] chs = str.toCharArray() ;
//        Arrays.sort(chs) ;
        fix(chs,0) ;
        result.sort((x1,x2)->x1.compareTo(x2));
        return result ;
    }

    //固定index及之前的char
    private void fix(char[] chs,int index){
        if(index==chs.length-1){
            result.add(new String(chs)) ;
            return ;
        }
        if(chs[0]=='c'){
            System.out.println(chs);
        }
        fix(chs,index+1) ;
        //交换index位
        for(int i=index+1;i<chs.length;i++){
            if(chs[i]!=chs[index]){
                //swap
                char tmp = chs[index] ;
                chs[index] = chs[i] ;
                chs[i] = tmp ;
                fix(chs,index+1) ;

                //swap
                tmp = chs[index] ;
                chs[index] = chs[i] ;
                chs[i] = tmp ;
            }
        }

    }

}
