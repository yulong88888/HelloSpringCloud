package net.lengmang.hello.spring.cloud.web.admin.feign.service;

import net.lengmang.hello.spring.cloud.web.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-spring-cloud-service-admin", fallback = AdminServiceHystrix.class)
public interface AdminService {

    @GetMapping("/hi")
    public String sayHello(@RequestParam(value = "msg") String message);
}
