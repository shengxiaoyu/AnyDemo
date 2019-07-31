package mianshiti.Zijietiaodong;

/**
 * @author 13314
 * @date 2019/6/30
 * @time 20:37
 * @Description
 */
public class _2 {
    public static void main(String[] args) {
        System.out.println(cal("aa", "a"));
    }
    public static boolean cal(String s,String p){
        char[] sChs = s.toCharArray() ;
        char[] pChs = p.toCharArray() ;
        int i1 = 0 ;
        int i2 = 0 ;
        while(i1<sChs.length && i2<pChs.length){
            if(pChs[i2]=='.'){
                i1++ ;
                i2++ ;
                continue;
            }
            if(pChs[i2]=='*'){
                if(sChs[i1]==pChs[i2-1]){
                    i1++ ;
                    continue;
                }
                if(sChs[i1]==pChs[i2+1]){
                    i1++ ;
                    i2++ ;
                    continue;
                }
                return false ;

            }
            if(pChs[i2]==sChs[i1]){
                i1++ ;
                i2++ ;
            }
        }
        if(i1!=sChs.length){
            return false ;
        }
        if(i2!=pChs.length){
            while(i2<pChs.length){
                if(pChs[i2]!='*'){
                    return false ;
                }
                i2++ ;
            }
        }
        return  true ;
    }
}
