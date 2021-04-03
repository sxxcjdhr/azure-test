package com.test.azure.test.sercurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * 拦截器
 */
public class TranslateInterceptor implements HandlerInterceptor {

    private final static Logger log = LoggerFactory.getLogger(TranslateInterceptor.class);

    long start = System.currentTimeMillis();

    private Set<String> ips;

    private Boolean ipAuthSwitch;

    public TranslateInterceptor( Set<String> ips, Boolean ipAuthSwitch) {
        this.ips = ips;
        this.ipAuthSwitch = ipAuthSwitch;
    }

    /**
     * preHandle是在请求执行前执行的
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        start = System.currentTimeMillis();

        String ip = request.getRemoteAddr();
        log.info("request ip: " + ip);

        /**
         * 返回true,postHandler和afterCompletion方法才能执行
         * 否则false为拒绝执行，起到拦截器控制作用
         */
        if (ipAuthSwitch) {
            if(StringUtils.isEmpty(ip) == false && ips.contains(ip)){
                return true;
            }else{
                log.info("ip:{} No authority", ip);
                return false;
            }
        }else{
            return true;
        }
    }

    /**
     * postHandler是在请求结束之后,视图渲染之前执行的,但只有preHandle方法返回true的时候才会执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Interception cost=" + (System.currentTimeMillis() - start));
    }

    /**
     * afterCompletion是视图渲染完成之后才执行,同样需要preHandle返回true
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //该方法通常用于清理资源等工作
    }

}
