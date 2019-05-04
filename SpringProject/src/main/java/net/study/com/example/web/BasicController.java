package net.study.com.example.web;


import net.study.com.example.domain.basic;
import net.study.com.example.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/basic")
public class BasicController {

    @Autowired
    BasicService basicService;

    @RequestMapping(value ="/1")
    public String basic(Map<String, Object> model){

        List<basic> basicEx = basicService.basic1go();

        model.put("basicEx", basicEx);
        return "basic/basic1";
    }

}
