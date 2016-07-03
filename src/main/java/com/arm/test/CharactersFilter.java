package com.arm.test;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Characters filter filters or handles character related operations
 */
public interface CharactersFilter {

    /**
     * Filters out empty characters from the input string
     *
     * @param string to remove empty characters
     * @param pattern {@code Pattern} to remove characters
     * @return Filtered list of empty characters
     */
    List<String> filterEmptyCharacters(String string, Pattern pattern);
}
