package com.arm.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for {@code CharacterFilter}
 */
public class CharacterFilterTest {

    Pattern pattern = Pattern.compile("[;,]");

    CharactersFilter charactersFilter = new CharactersFilterImpl();

    @Test
    public void shouldFilterEmptyCharacters() {
        List<String> expected = Lists.newArrayList("2","3");

        List<String> filteredCharacters = charactersFilter.filterEmptyCharacters(";2,3", pattern);

        assertThat(filteredCharacters, is(expected));
    }
}
