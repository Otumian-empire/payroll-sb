package com.otumian.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index() {
        logger.info("GetMapping('/') -> Index page");
        return "Welcome to the Payroll App.";
    }

}
