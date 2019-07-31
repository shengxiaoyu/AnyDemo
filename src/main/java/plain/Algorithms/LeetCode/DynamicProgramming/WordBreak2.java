package plain.Algorithms.LeetCode.DynamicProgramming;

import java.util.*;

/**
 * @author 13314
 * @date 2019/7/27
 * @time 20:07
 * @Description
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid
 * dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreak2 {
    public static void main(String[] args) {

        String s = "catsanddog" ;

        System.out.println(s.substring(s.length()));
        String[] words = {"cat", "cats", "and", "sand", "dog"} ;
        HashSet<String> dict = new HashSet<>() ;
        for(String word:words){
            dict.add(word) ;
        }
//        System.out.println(new WordBreak2().wordBreak(s, dict));
        ArrayList<String> strings = new WordBreak2().wordBreak3(s, dict);
        System.out.println(new WordBreak2().wordBreak4(s,dict));
    }
    private ArrayList<String> res ;
    //递归暴力
    public ArrayList<String> wordBreak(String s, Set<String> dict){
        res = new ArrayList<>() ;
        wordB(s,0,dict);
        return res ;
    }
    private void wordB(String s,int index,Set<String>dict){
        for(int i=index+1;i<=s.length();i++){
            if(dict.contains(s.substring(index,i))){
                if(i==s.length()){
                    res.add(s.substring(0,index)+" "+s.substring(index)) ;
                }else{
                    wordB((s.substring(0,i)+" "+s.substring(i)),i+1,dict);
                }
            }
        }
    }





//复杂度过高
    public ArrayList<String> wordBreak2(String s,Set<String> dict){
        HashMap<Integer,ArrayList<String>> strs = new HashMap<>() ;
        ArrayList<String> init = new ArrayList<>(0) ;
        init.add("") ;
        strs.put(0,init) ;
        String word = "" ;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                word = s.substring(j,i) ;
                if(dict.contains(word)&&strs.containsKey(j)){
                    ArrayList<String> theList = strs.get(i) ;
                    if(theList==null){
                        theList = new ArrayList<>() ;
                    }
                    ArrayList<String> lastList = strs.get(j) ;
                    for(String str:lastList){
                        if(str!=""){
                            theList.add(str+" "+word) ;
                        }else{
                            theList.add(word) ;
                        }
                    }
                    strs.put(i,theList) ;
                }
            }
        }
        return strs.get(s.length()) ;
    }

    public ArrayList<String> wordBreak3(String s,Set<String> dict){
        //用来缓存所有的字符串对应的结果集
        HashMap<String,ArrayList<String>> map = new HashMap() ;
        return dfs(s,dict,map) ;

    }
    private ArrayList<String> dfs(String s,Set<String>dict,HashMap<String,ArrayList<String>> map){
        if(map.containsKey(s)){
            return map.get(s) ;
        }
        ArrayList<String> list = new ArrayList() ;
        if(s.equals("")){
            list.add("") ;
        }else{
            String word = null ;
            for(int i=1;i<=s.length();i++){
                word = s.substring(0,i) ;
                if(dict.contains(word)){
                    ArrayList<String> lastList = dfs(s.substring(i),dict,map) ;
                    if(lastList.size()!=0){
                        for(String str:lastList){
                            if(str!=""){
                                list.add(word+" "+str) ;
                            }else{
                                list.add(word) ;
                            }
                        }
                    }
                }
            }

        }
        map.put(s,list);
        return list ;

    }

    public boolean wordBreak4(String s, Set<String> dict) {
        boolean[] tube = new boolean[s.length()+1] ;
        tube[0] = true ;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(tube[j]==true && dict.contains(s.substring(j,i))){
                    tube[i]=true ;
                    break ;
                }
            }
        }

        return tube[s.length()] ;
    }
}
