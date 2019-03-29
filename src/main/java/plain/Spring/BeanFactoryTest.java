package plain.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 13314409603@163.com
 * @date 2019/3/23
 * @time 17:58
 * @Description
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
        Price price = context.getBean("price", Price.class);
        System.out.println(price);
    }
}
