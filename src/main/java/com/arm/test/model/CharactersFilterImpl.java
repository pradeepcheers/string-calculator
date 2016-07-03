package com.arm.test.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Default implementation for {@code CharacterFilter}
 */
@Component
public class CharactersFilterImpl implements CharactersFilter {

    private static final String EMPTY_STRING = "";

    @Override
    public List<String> filterEmptyCharacters(String string, Pattern pattern) {
        return pattern.splitAsStream(string)
                .filter(seq -> !seq.equals(EMPTY_STRING))
                .collect(Collectors.toList());
    }
}
