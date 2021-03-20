package com.test.azure.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiuxian.song
 * @version 1.0
 * @create: 2021-03-19 22:36
 */
@Controller
@RequestMapping(value = "/api", produces = {"application/json"})
public class ApiController {
    @RequestMapping("/health")
    @ResponseBody
    public Object health() {
        Map<String,String> map = new HashMap<String, String>();
        try{
            map.put("status", "UP");
        }catch(Exception ex){
            map.put("status", "DOWN");
        }
        return map;
    }
}
