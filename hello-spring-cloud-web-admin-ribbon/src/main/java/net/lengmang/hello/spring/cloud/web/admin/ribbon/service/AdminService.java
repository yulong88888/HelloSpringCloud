package net.lengmang.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHello(String message) {
        return restTemplate.getForObject("http://hello-spring-cloud-service-admin/hi?msg=" + message, String.class);
    }

    public String helloError(String message) {
        return String.format("Hello, your message is : %s but request bad", message);
    }
}
