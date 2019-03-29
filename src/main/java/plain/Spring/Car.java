package plain.Spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 13314409603@163.com
 * @date 2019/3/28
 * @time 9:56
 * @Description
 */
public class Car {
    private String name ;
    private double maxSpeed ;
    private double value ;
    @Autowired
    private Price price ;

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setValue(double value) {
        this.value = value;
    }
//    public void setPrice(Price price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", value=" + value +
                ", price=" + price +
                '}';
    }
}
