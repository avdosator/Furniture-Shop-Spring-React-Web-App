package com.avdo.spring_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public Map<String, String> test() {
        Map<String, String> response = new HashMap<>(1);
        response.put("message", "Hello from backend");
        return response;
    }
}
