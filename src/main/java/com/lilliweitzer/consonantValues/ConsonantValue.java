package com.lilliweitzer.consonantValues;

import java.util.ArrayList;
import java.util.List;

public class ConsonantValue {

    private final String vowels;
    private final List<Character> consonants;

    public ConsonantValue(String vowels) {
        this.vowels = vowels;
        this.consonants = new ArrayList<>();
    }

    public int solve(final String stringInput) {
        int maxConsonantValue = 0;

        maxConsonantValue = getConsonantValue(stringInput, maxConsonantValue);

        int lastSubstringValue = getLastSubstringValue();
        maxConsonantValue = getMaxConsonantValue(maxConsonantValue, lastSubstringValue);

        return maxConsonantValue;
    }

    private int getLastSubstringValue() {
        return consonants.stream()
                .mapToInt(consonant -> consonant - 'a' + 1)
                .sum();
    }

    private int getConsonantValue(String stringInput, int maxConsonantValue) {
        for (char character : stringInput.toCharArray()) {
            if (vowels.indexOf(character) == -1) {
                consonants.add(character);
            } else {
                int substringValue = getLastSubstringValue();
                maxConsonantValue = getMaxConsonantValue(maxConsonantValue, substringValue);
                consonants.clear();
            }
        }
        return maxConsonantValue;
    }

    private static int getMaxConsonantValue(int maxConsonantValue, int substringValue) {
        return Math.max(maxConsonantValue, substringValue);
    }
}
