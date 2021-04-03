//package com.test.azure.test.sercurity;
//import com.test.azure.test.sercurity.TranslateInterceptor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * 拦截器配置
// */
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//
//    @Value("${ips}")
//    private String ips;
//    @Value("${ipAuthSwitch}")
//    private Boolean ipAuthSwitch;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        String[] split = ips.split(",");
//        for(int i = 0; i < split.length; i ++){
//            split[i] = split[i].trim();
//        }
//        Set<String> ipSet = new HashSet<>(Arrays.asList(split));
//
//        registry.addInterceptor(new TranslateInterceptor(ipSet, ipAuthSwitch))
//                //添加需要验证登录用户操作权限的请求
//                .addPathPatterns("/**")
//                //这里add为“/**”,下面的exclude才起作用，且不管controller层是否有匹配客户端请求，拦截器都起作用拦截
//                //排除不需要验证登录用户操作权限的请求
//                .excludePathPatterns("/wang")
//                .excludePathPatterns("/css/**")
//                .excludePathPatterns("/js/**")
//                .excludePathPatterns("/images/**");
//        //这里可以用registry.addInterceptor添加多个拦截器实例，后面加上匹配模式
//        super.addInterceptors(registry);//最后将register往这里塞进去就可以了
//    }
//}
