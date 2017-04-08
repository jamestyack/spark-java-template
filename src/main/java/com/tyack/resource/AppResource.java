package com.tyack.resource;

import com.tyack.exception.NotFoundException;
import com.tyack.service.AppService;
import com.tyack.transformer.JsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

/**
 * Resource where routes are defined.
 */
public class AppResource extends CommonResource {

    final static Logger logger = LoggerFactory.getLogger(AppResource.class);

    private final AppService appService;

    /**
     * Creates new AppResource instance using given AppService
     *
     * @param appService
     */
    public AppResource(AppService appService) {
        this.appService = appService;
        setupEndpoints();
    }

    private void setupEndpoints() {

        /**
         * Sample endpoint GET /api/v1/greeting
         */
        get(API_CONTEXT + "/greeting", (request, response) -> {
            response.type("application/json");
            return appService.sayHello();
        }, new JsonTransformer());

        /**
         * Sample endpoint GET /api/v1/greeting/:name
         */
        get(API_CONTEXT + "/greeting/:name", (request, response) -> {
            response.type("application/json");
            return appService.sayHello(request.params("name"));
        }, new JsonTransformer());

        /**
         * Sample endpoint GET /api/v1/sampledata
         */
        get(API_CONTEXT + "/sampledata", (request, response) -> {
            response.type("application/json");
            return appService.getSampleData("blah");
        }, new JsonTransformer());


        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });

        // exception mappers

        exception(NotFoundException.class, (e, request, response) -> {
            response.status(404);
            response.body(jsonError(e.getMessage()));
        });

        // CORS - see https://sparktutorials.github.io/2016/05/01/cors.html

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

    }

}
