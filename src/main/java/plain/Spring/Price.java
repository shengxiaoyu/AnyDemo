package plain.Spring;

/**
 * @author 13314409603@163.com
 * @date 2019/3/28
 * @time 10:29
 * @Description
 */
public class Price {
    private String myUnit ;
    private Double myNumber ;
    public Price(){}
    public Price(String unit,Double number){
        this.myNumber = number ;
        this.myUnit = unit ;
    }

    @Override
    public String toString() {
        return "Price{" +
                "unit='" + myUnit + '\'' +
                ", number=" + myNumber +
                '}';
    }
}
