package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 13314409603@163.com
 * @date 2019/3/28
 * @time 15:27
 * @Description
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello.do",method = RequestMethod.GET)
    public String hello(){
//        modelMap.addAttribute("message","Hello Web!") ;
        return "hello";
    }
}
