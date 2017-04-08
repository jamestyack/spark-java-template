package com.tyack;

import com.tyack.resource.AppResource;
import com.tyack.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;
 
public class App {
    
    final static Logger logger = LoggerFactory.getLogger(App.class);

    private static final int PORT = 4567;
 
    public static void main(String[] args) throws Exception {
        port(PORT);
        staticFileLocation("/public");
        new AppResource(new AppService());
        logger.info("Starting up");
    }

}