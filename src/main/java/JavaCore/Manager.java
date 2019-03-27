package JavaCore;

import java.util.Objects;

/**
 * @author 13314409603@163.com
 * @date 2018/12/25
 * @time 11:01
 * @Description
 */
public class Manager extends Employee {
    int bonus ;
    public int getBonus(){
        return bonus ;
    }

    public Manager(){
        super();
    }
    public Manager(String aName,int aBonus){
        super(aName);
        bonus = aBonus ;
    }

    /**
     * 不是覆盖，覆盖方法参数不可变
     * @param aInt
     */
    public void print(Integer aInt){
        System.out.println(aInt);
    }
    @Override
    public boolean equals(Object otherObject){
        super.equals(otherObject) ;
        if(this == otherObject){
            return true ;
        }
        if(otherObject == null){
            return false ;
        }
        if(getClass() != otherObject.getClass()){
            return false ;
        }
        Manager other = (Manager) otherObject;
        return bonus == other.bonus ;
    }

}
