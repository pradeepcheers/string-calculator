package com.arm.test.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Tests for {@code StringCalculatorController}
 */
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;

    @InjectMocks
    private StringCalculatorController stringCalculatorController = new StringCalculatorController();

    @Mock
    private StringCalculatorService stringCalculatorService;

    @Before
    public void init() {
        mockMvc = standaloneSetup(stringCalculatorController).build();
    }

    @Test
    public void testAdd() throws Exception {
        String numbers = "{1,2}";

        when(stringCalculatorService.add(numbers)).thenReturn(3);

        mockMvc
            .perform(post("/add")
                        .accept(MediaType.parseMediaType(CONTENT_TYPE))
                        .content(numbers))
            .andExpect(status().isOk())
            .andExpect(content().contentType(CONTENT_TYPE))
            .andExpect(content().string("3"));
    }
}
