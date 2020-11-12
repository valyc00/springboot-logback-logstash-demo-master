package com.evan.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Evan on 2017-07-03.
 */

@RestController
@RequestMapping("demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String demo() {

    	String logData="mymdc";
		MDC.put("logData", logData);
        logger.error("====> This is an error log");
        logger.info("====> This is an info log");
        logger.warn("====> This is an warn log");
        MDC.clear();

        try {
            throw new Exception("This is an exception");
        } catch (Exception e) {
            logger.error("====> This is an error log with stack trace", e);
        }
        return "Hello World";
    }

}
