package plain.pingduoduo;

import java.util.Scanner;

/**
 * @author 13314
 * @date 2019/7/28
 * @time 15:19
 * @Description
 */
public class _2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String[] words = {"CAT","TIGER","RPC"} ;
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            String line = in.nextLine() ;
//            words = line.split(" ") ;
//        }
        int len = words.length ;
        String last = words[len-1] ;
        boolean res = search(words,len-1,last.charAt(0)) ;
        if(res){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    private static boolean search(String[] words,int index,char target){
        if(index==0){
            String word = words[0] ;
            String last = words[words.length-1] ;
            boolean res = word.charAt(word.length()-1)==target ;
            res &= word.charAt(0)==last.charAt(last.length()-1) ;
            return  res;
        }
        boolean result = false ;
        for(int i=index;i>=0;i--){
            //遍历判断是否有某个词尾是target
            if(words[i].endsWith(target+"")){
                String tmp = words[i] ;
                words[i] = words[index] ;
                words[index] = tmp ;
                result = search(words,index-1,words[index].charAt(0)) ;
                if(result==true){
                    return  true ;
                }
                tmp = words[i] ;
                words[i] = words[index] ;
                words[index] = tmp ;
            }
        }
        return false ;
    }
}
