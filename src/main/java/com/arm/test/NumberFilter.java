package com.arm.test;

import java.util.List;

/**
 * Number filter filters or handles number related operations
 */
public interface NumberFilter {

    List<Integer> filterBigNumbers(List<Integer> listOfNumbers, Integer limit);
}
