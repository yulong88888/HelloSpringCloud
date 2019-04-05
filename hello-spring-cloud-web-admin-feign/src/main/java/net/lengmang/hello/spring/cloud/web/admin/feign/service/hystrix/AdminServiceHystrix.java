package net.lengmang.hello.spring.cloud.web.admin.feign.service.hystrix;

import net.lengmang.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHello(String message) {
        return String.format("Hello, your message is : %s but request bad", message);
    }
}
