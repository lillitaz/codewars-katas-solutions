package com.lilliweitzer.tidyNumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TidyNumberTests {

    TidyNumber tidyNumber = new TidyNumber();

    @ParameterizedTest
    @CsvSource({"12, true", "32, false", "39, true", "1024, false", "12576, false", "13579, true", "2335, true"})
    public void Check_Small_Values(int input, boolean expected) {
        assertEquals(expected, tidyNumber.evaluateTidiness(input));
    }

    @ParameterizedTest
    @CsvSource({"1024, false", "12576, false", "13579, true", "2335, true"})
    public void Check_Larger_Values(int input, boolean expected) {
        assertEquals(expected, tidyNumber.evaluateTidiness(input));
    }
}
