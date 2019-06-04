package plain.Algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * @author 13314409603@163.com
 * @date 2018/12/22
 * @time 17:08
 * @Description
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] p = {1,5,8,9,10,17,17,20,24,30} ;
        System.out.println(DynamicProgramming.cut(p, 4));
        System.out.println(cutMemo(p,4));
        System.out.println(buttom_up_cut(p,4));
    }
    //递归
    public static int cut(int[] p, int n){
        if(n==0){
            return 0 ;
        }
        int q = Integer.MIN_VALUE ;
        for(int i=1;i<=n;i++){
            q = Math.max(q,p[i-1]+cut(p,n-i)) ;
        }
        return q ;
    }
    //备忘录
    public static int cutMemo(int[] p,int n){
        int[] r = new int[n+1] ;
        Arrays.fill(r,-1);
        return cut2(p,n,r) ;
    }
    public static int cut2(int[] p,int n,int[] r){
        if(n==0){
            return 0;
        }
        if(r[n]!=-1){
            return r[n];
        }
        int q = Integer.MIN_VALUE ;
        for(int i=1;i<=n;i++){
            q = Math.max(q,p[i-1]+cut2(p,n-i,r)) ;
        }
        r[n] = q ;
        return q ;
    }

    //自底向上
    public static int buttom_up_cut(int[] p,int n){
        int[] r = new int[n+1] ;
        for(int i=1;i<r.length;i++){
            int q = Integer.MIN_VALUE ;
            for(int j = 1;j <= i;j++){
                q = Math.max(q,p[j-1]+r[i-j]) ;
            }
            r[i] = q;
        }
        return r[n];
    }

    //爬楼梯
    public static int Memo2(int n){
        int[] r = new int[n+1] ;
        Arrays.fill(r,0) ;
        return f(r, n);
    }
    public static int f(int[] r,int n){
        if(r[n]!=0){
            return r[n] ;
        }
        if(n==1){
            return 1 ;
        }
        if(n==2){
            return 2 ;
        }
        int q = f(r,n-1)+f(r,n-2) ;
        r[n]=q ;
        return r[n] ;
    }

    public static int bottom_up(int n){
        int[] r = new int[n+1] ;
        r[1]=1;
        r[2]=2;
        for(int i=3;i<=n;i++){
            r[i]=r[i-1]+r[i-2] ;
        }
        return r[n] ;
    }
    //小朋友过河

    /**
     *
     * 在一个夜黑风高的晚上，有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥，但是由于桥很窄，每次只允许不大于两人通过，
     * 他们只有一个手电筒，所以每次过桥的两个人需要把手电筒带回来，i号小朋友过桥的时间为T[i]，两个人过桥的总时间为二者中时间长者。
     * 问所有小朋友过桥的总时间最短是多少。
     * 关键点：先将小朋友按过河时间递增排序,得到数组T；然后考虑问题的特殊情况，5个人的时候可以采取1，2先去，1回来，4，5过去，2回来这种方式使得4不被计算
     * 同时，这种时候花费掉了T[1]+T[0]+T[4]+T[2]的方式把4，5送过去了也就是用1，2*2的时间换取了4的时间，就要考虑是否比一直用
     *  f(1)=T[0],f(2)=T[1],f(3)=T[0]+T[1]+T[2],f(4)=T[4]+T[0]+f(3),f(5)=min(T[0]+T[n]+T[n-1},T[1]+T[n]+T[2]+f(n-2))
     * @param a
     * @return
     */
    public static int b_u(int[] a){
        Arrays.sort(a);
        int[] r = new int[a.length+1] ;
        if(a.length==1){
            r[1] = a[0] ;
        }
        if(a.length==2){
            r[2] =  a[0]+a[1] ;
        }
        if(a.length==3){
            r[3] =  a[0]+a[1]+a[2] ;
        }
        for(int i=4;i<=a.length;i++){
            r[i] = Math.min(a[i]+a[1]+r[i-1],a[2]+a[1]+a[i]+a[2]+r[i-2]) ;
        }
        return r[a.length] ;
    }
    //最少回文字符串
    public static int b_u2(String str){
        if(str.isEmpty()||str.length()==1){
            return 0 ;
        }
        if(str.charAt(0)==str.charAt(str.length()-1)){
            return b_u2(str.substring(1,str.length()-1))+1 ;
        }else {
            return Math.min(b_u2(str.charAt(0)+str),b_u2(str+str.charAt(str.length()-1))) ;
        }
    }
    //背包问题1
    public static int b_u3(int[] a,int[] b,int V){
        return f(a,b,V,a.length-1) ;
    }
    public static int f(int[] a,int[] b,int V,int index){
        if(index==0){
            if(a[0]<V){
                return b[0] ;
            }else {
                return 0 ;
            }
        }
        if(a[index]<V){
            return Math.max(b[index]+f(a,b,V-b[index],index-1),f(a,b,V,index-1)) ;
        }else {
            return f(a,b,V,index-1) ;
        }
    }
    //背包问题2
    public static int b_u4(int[] a,int[] w,int V){
        int[][] f = new int[a.length+1][V+1] ;
        for(int i=1;i<=a.length;i++){
            for (int v = 1; v <= V; v++) {
                if (v >= a[i]) {
                    f[i][v] = Math.max(f[i-1][v], f[i-1][v - a[i]] + w[i]);
                } else {
                    f[i][v] = f[i-1][v];
                }
            }
        }
        return f[a.length][V];
    }
}
