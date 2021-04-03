package com.test.azure.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiuxian.song
 * @version 1.0
 * @create: 2021-03-19 22:36
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {
    private final static Logger log = LoggerFactory.getLogger(ApiController.class);
    @RequestMapping(value = "/health", method = RequestMethod.POST)
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

    @ResponseBody
    @RequestMapping(value = "/AuthTest", method = RequestMethod.GET)
    public String AuthTest() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return "OK";
    }

    @Scheduled(fixedRate=20000)
    public void test(){
        log.info("test");
    }


}
