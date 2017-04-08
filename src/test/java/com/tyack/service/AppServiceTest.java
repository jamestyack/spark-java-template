package com.tyack.service;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jamestyack on 11/14/15.
 */
public class AppServiceTest {

    @Before
    public void setup() {
    }

    @Test
    public void testSayHello() {
        final Map<String, String> result = new AppService().sayHello();
        assertEquals("hello", result.get("message"));
    }

    @Test
    public void testSayHelloWithName() {
        final Map<String, String> result = new AppService().sayHello("fred");
        assertEquals("hello fred", result.get("message"));
    }

}