package com.arm.test;

import java.util.List;

/**
 * Number filter filters or handles number related operations
 */
public interface NumbersFilter {

    List<Integer> filterBigNumbers(List<Integer> listOfNumbers, Integer limit);

    List<Integer> logNegativeNumberAndThrowException(List<Integer> listOfNumbers);

    List<Integer> mapToInt(List<String> listOfString);
}
