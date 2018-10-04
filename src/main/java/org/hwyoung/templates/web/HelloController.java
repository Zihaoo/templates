package org.hwyoung.templates.web;
import org.hwyoung.templates.domain.Resource;
import org.hwyoung.templates.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

// restcontroller = controller + responsbody  返回json
//@RestController
@Controller
public class HelloController {

    @Autowired
    Resource resource;

    @Value("${com.source.name}")
    String cname;

    @RequestMapping("/hello")
    public String hello(){
        String str = resource.getName();
        if(cname.equals(str)){
            str = "ok";
        }
        return str ;
    }

    @RequestMapping("/user")
    public String user(ModelMap modelMap){
        User u = new User();
        u.setName("jackson");
        u.setAge(18);
        u.setBirthday(new Date());
        modelMap.addAttribute("user",u);
        return "thymeleaf/index";
    }

//    @RequestMapping("/index")
//    public String index(){
//        return "thymeleaf/index";
//    }
}
