package JavaCore;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 13314409603@163.com
 * @date 2018/12/25
 * @time 11:02
 * @Description
 */
public class Test {
    public static void main(String[] args){
        String[]  array = new String[]{"11","22","33"} ;
        List<String> strings = Arrays.asList(array);
        Stream<Employee> employeeStream = strings.stream().map(Employee::new);
        List<Employee> collect = employeeStream.collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));
    }
}
