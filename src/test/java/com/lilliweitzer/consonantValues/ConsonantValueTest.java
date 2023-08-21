package com.lilliweitzer.consonantValues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class ConsonantValueTest {
    ConsonantValue consonantValue = new ConsonantValue("aeiou");

    @ParameterizedTest
    @CsvSource({"zodiac, 26", "chruschtschov, 80", "khruhschev, 38", "strength, 57", "catchphrase, 73", "twelfthstreet, 103", "mischtschenkoana, 80"})
    public void Check_Small_Values(String input, int expected) {
        assertEquals(expected, consonantValue.solve(input));
    }
}