package net.lengmang.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置过滤类型，有四种不同生命周期的过滤器类型
 * 1. pre：路由之前
 * 2. routing：路由之时
 * 3. post：路由之后
 * 4. error：发送错误调用
 */
@Slf4j
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext curretContext = RequestContext.getCurrentContext();
        HttpServletRequest request = curretContext.getRequest();
        log.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (token == null) {
            log.warn("Token is empty");
            curretContext.setSendZuulResponse(false);
            curretContext.setResponseStatusCode(401);
            try {
                HttpServletResponse response = curretContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                curretContext.getResponse().getWriter().write("Token is empty");
            } catch (IOException e) {
            }
        } else {
            log.info("OK");
        }
        return null;
    }
}
