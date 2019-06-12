package com.my.ssm.ctl.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author WJ
 * @version 1.0.0
 * @className SwaggerController
 * @description swaggerController
 * @date 2019-06-06 17:02
 */
@Controller
@RequestMapping(value = "/myssm")
public class SwaggerController {

    @RequestMapping(value = "/swagger", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView suggAdd() {
        ModelAndView model = new ModelAndView("swagger/swagger");
        return model;
    }
}
