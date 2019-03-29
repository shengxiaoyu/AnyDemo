package plain.Algorithms.JianZhiOffer;

/**
 * @author 13314409603@163.com
 * @date 2019/3/29
 * @time 21:58
 * @Description
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 不新建str方法
 */
public class _2 {
    public String replaceSpace(StringBuffer str) {
        if(str==null || str.length()==0){
            return "" ;
        }
        int length = str.length() ;
        int newlength = length ;
        int count = 0;
        for(int i=0;i<length;i++){
            if(str.charAt(i)==' '){
                count++ ;
            }
        }
        newlength += count*2 ;
        str.setLength(newlength);
        while (count>0){
            if(str.charAt(length-1)==' '){
                str.setCharAt(--newlength,'0');
                str.setCharAt(--newlength,'2');
                str.setCharAt(--newlength,'%');
                count-- ;
            }else {
                str.setCharAt(--newlength,str.charAt(length-1));
            }
            length-- ;
        }
        return str.toString() ;
    }
}
