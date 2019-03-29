package plain.JavaCore;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 13314409603@163.com
 * @date 2018/12/25
 * @time 11:01
 * @Description
 */
public class Employee implements Cloneable,Comparable,Serializable{
    protected String name ;

    public Employee(){}
    public Employee(String aName){
        name = aName ;
    }
    public String getName(){
        return name ;
    }
    public void print(Number number){
        System.out.println(number);
    }
    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true ;
        }
        if(otherObject == null ){
            return false ;
        }
        if(getClass() != otherObject.getClass()){
            return false ;
        }
        Employee other = (Employee)otherObject ;
        return Objects.equals(name,other.getName()) ;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
