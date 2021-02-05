package com.allweing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: zzzgyu
 */
@RestController
public class BaseController {
    Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/base",method = RequestMethod.GET)
    public String base() {

        LOGGER.trace("-------tract-----------");
        LOGGER.debug("-------debug---------");
        LOGGER.info("----------info-----------");
        LOGGER.warn("-------warn----------");
        LOGGER.error("---------error-----------");
        return "base";
    }

}
