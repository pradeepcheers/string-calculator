package com.arm.test.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.util.Assert.hasText;

/**
 * Controller class for {@code StringCalculator}
 */
@Controller
@EnableAutoConfiguration
public class StringCalculatorController {

    private StringCalculatorService stringCalculatorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Integer add(@RequestBody String numbers) {
        hasText(numbers);

        return stringCalculatorService.add(numbers);
    }

    @Autowired
    public void setStringCalculatorService(StringCalculatorService stringCalculatorService) {
        this.stringCalculatorService = stringCalculatorService;
    }
}
