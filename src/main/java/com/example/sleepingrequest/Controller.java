package com.example.sleepingrequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value="/sleep/{timeInMilliSeconds}", method = RequestMethod.GET)
    public boolean sleep(@PathVariable("timeInMilliSeconds") int timeInMilliSeconds) {

        logger.info("Sleeping: " + timeInMilliSeconds + "ms");
        try {
            Thread.sleep(timeInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Number of threads: " + Thread.activeCount());
        logger.info("Done sleeping");
        return true;
    }
}
