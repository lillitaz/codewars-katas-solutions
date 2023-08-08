package com.lilliweitzer.tidyNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TidyNumber {

    public boolean evaluateTidiness(int number) {
        List<Integer> numberList = convertNumberToList(number);

        return IntStream.range(1, numberList.size())
                .noneMatch(i -> numberList.get(i) < numberList.get(i - 1));
    }

    private List<Integer> convertNumberToList(int number) {
        List<Integer> numberList = new ArrayList<>();
        while (number > 0) {
            numberList.add(0, number % 10);
            number /= 10;
        }
        return numberList;
    }
}
