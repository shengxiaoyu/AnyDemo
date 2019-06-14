package plain.Algorithms.KickStart;

import java.util.*;

/**
 * @author 13314409603@163.com
 * @date 2019/6/14
 * @time 21:04
 * @Description: Given a dictionary, can you count the number of words in the dictionary that appear as a substring in the given
 * string at least once, in either their scrambled of original forms.(a scrambled form consists of the same set of letters with the first
 * and last letters in the same places, and the others in any ordder.)
 * The dictionary has L words made of lowercase English letters. The string is S, N is the length of S
 * The sum of lengths of all words in the dictionary does not exceed 10^5.
 * 基本思路：遍历字符串，针对每个位置。分别匹配每个word是否出现过
 * 优化1：判断word是否相同，只需要判断首尾字符是否相同，以及中间字符不考虑顺序是否相同，可以使用一个26长度的char数组来判断每个char的出现次数，
 *      当出现次数都相同时，两个word的中间字符不考虑顺序是相同的。更进一步，可以把数组hash值用来判断是否相同。
 * 优化2：针对每个位置，相同长度的words可以一起判断，这样减少遍历。
 */
public class ScrambledWords {

    public static int cal(int L,String[] dictionary,char s1,char s2,int N,int A,int B,int C,int D){
        String s = generateS(s1,s2,N,A,B,C,D) ;
        s = "aapxjdnrbtvldptfzbbdbbzxtndrvjblnzjfpvhdhhpxjdnrbt";
        //先把相同的word分为一组
        HashMap<Integer,Set<String>> len_dict = new HashMap<>(dictionary.length) ;
        for(String word:dictionary){
            if(!len_dict.containsKey(word.length())){
                len_dict.put(word.length(),new HashSet<>()) ;
            }
            len_dict.get(word.length()).add(word) ;
        }
        //记录出现过的word个数
        int count = 0 ;
        for(int i=0;i<s.length();i++){
            for(int len:len_dict.keySet()){
                if(i+len>s.length()){
                    continue;
                }
                String subStr = s.substring(i,i+len) ;
                Set<String> words = len_dict.get(len) ;
                Iterator<String> iterator = words.iterator();
                while (iterator.hasNext()){
                    if(myHash(iterator.next())==myHash(subStr)){
                        iterator.remove();
                        count++ ;
                    }
                }
//                for(String word:len_dict.get(len)){
//                    if(myHash(subStr)==myHash(word)){
//                        count++ ;
//                        //擦除出现过的word，避免后面重复计算
//                        len_dict.get(len).remove(word) ;
//                    }
//                }
            }
        }
        return count ;
    }
    //获取word的一种hash值，该值和中间字符的顺序无关
    private static long myHash(String word){
        int[] ints = new int[26] ;
        for(int i=1;i<word.length()-1;i++){
            ints[i]++ ;
        }
        long hash = 133*word.charAt(0)+word.charAt(word.length()-1) ;
        for(int i=0;i<26;i++){
            hash = hash*133+ints[i] ;
        }
        return hash ;
    }

    public static String generateS(char s1,char s2,int N, int A,int B,int C,int D){
        char[] s = new char[N] ;
        s[0] = s1 ;
        s[1] = s2 ;
        for(int i=3;i<=N;i++){
            s[i-1] = aChar(97+(((A*ord(s[i-2])+B*ord(s[i-3])+C)%D)%26)) ;
        }
        return s.toString() ;
    }


    private static int ord(char ch){
        return 97+ch-'a' ;
    }
    private static char aChar(int n){
        return (char)('a'+(n-97)) ;
    }
    public static void main(String[] args) {
        System.out.println(ScrambledWords.cal(5, new String[]{"axpaj", "apxaj", "dnrbt", "pjxdn", "abn"}, 'a', 'a', 50, 1, 1, 1, 30));
    }
}
