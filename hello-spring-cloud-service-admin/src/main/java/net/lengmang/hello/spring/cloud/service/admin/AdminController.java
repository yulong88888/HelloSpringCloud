package net.lengmang.hello.spring.cloud.service.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String sayHello(@RequestParam(value = "msg") String message) {
        return String.format("Hello, your message is : %s i am from port : %s", message, port);
    }
}
