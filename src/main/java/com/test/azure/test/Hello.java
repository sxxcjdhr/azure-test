package com.test.azure.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiuxian.song
 * @version 1.0
 * @create: 2021-03-19 16:26
 */
@RestController
public class Hello {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
