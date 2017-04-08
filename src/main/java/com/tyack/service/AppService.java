package com.tyack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class AppService {

    final static Logger logger = LoggerFactory.getLogger(AppService.class);

    public AppService() {
        // TODO
    }

    public Map<String, String> sayHello() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "hello");
        return result;
    }

    public Map<String, String> sayHello(String name) {
        Map<String, String> result = new HashMap<>();
        result.put("message", "hello " + name);
        return result;
    }
}
