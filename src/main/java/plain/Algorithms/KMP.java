package plain.Algorithms;

/**
 * @author 13314
 * @date 2019/7/6
 * @time 9:58
 * @Description
 * 有一个字符串S和一个匹配字符串P，查找P在S中的位置
 */
public class KMP {
    public static void main(String[] args) {
        String s = "bbc abcdab abcdabcdabde" ;
        String p = "abcdabd" ;
        System.out.println(violence(s,p));
        System.out.println(kmp(s,p));
    }
    public static int violence(String s,String p){
        char[] sChs = s.toCharArray() ;
        char[] pChs = p.toCharArray() ;
        for(int i=0;i<sChs.length;i++){
            int j = 0 ;
            for(;j<pChs.length;j++){
                if(sChs[i+j]!=pChs[j]){
                    break;
                }
            }
            if(j==pChs.length){
                return i ;
            }
        }
        return -1 ;
    }
    public static int kmp(String s,String p){
        //使用KMP算法，首先计算匹配字符串P的next数组
        int[] next = getNext(p) ;
        int i=0 ;
        int j = 0 ;
        int sLen = s.length() ;
        int pLen = p.length() ;
        char[] sChs = s.toCharArray() ;
        char[] pChs = p.toCharArray() ;
        while (i<sLen && j<pLen){
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if(j==-1 || sChs[i] == pChs[j]){
                j++ ;
                i++ ;
            }else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j] ;
            }
        }
        if(j==pLen){
            return i- j ;
        }else {
            return -1 ;
        }
    }
    private static int[] getNext(String p){
        char[] pChs = p.toCharArray() ;
        int[] next = new int[p.length()] ;
        next[0] = -1 ;
        int k = -1 ;
        int j = 0 ;
        while (j<pChs.length-1){
            if(k==-1 ||pChs[j] == pChs[k]){
                k++ ;
                j++ ;
                next[j] = k ;
            }else {
                k = next[k] ;
            }
        }
        return next ;
    }
}
