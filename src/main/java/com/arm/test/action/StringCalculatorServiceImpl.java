package com.arm.test.action;

import com.arm.test.model.StringCalculator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation for {@code StringCalculatorService}
 */
public class StringCalculatorServiceImpl implements StringCalculatorService {

    @Autowired
    private StringCalculator stringCalculator;

    @Override
    public int add(String numbers) {
        return stringCalculator.add(numbers);
    }
}
