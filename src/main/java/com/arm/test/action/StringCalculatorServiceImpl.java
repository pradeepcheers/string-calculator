package com.arm.test.action;

import com.arm.test.model.StringCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for {@code StringCalculatorService}
 */
@Service
public class StringCalculatorServiceImpl implements StringCalculatorService {

    private StringCalculator stringCalculator;

    @Override
    public int add(String numbers) {
        return stringCalculator.add(numbers);
    }

    @Autowired
    public void setStringCalculator(StringCalculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }
}
