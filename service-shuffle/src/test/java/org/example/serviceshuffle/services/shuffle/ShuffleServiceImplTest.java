package org.example.serviceshuffle.services.shuffle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleServiceImplTest {

    ShuffleService shuffleService = new ShuffleServiceImpl();

    @ParameterizedTest
    @ValueSource(ints = {3, 500, 1000})
    void testGenerateShuffledNumbersWhenUseValueWithinRangeWhenConvertListToSetThenSizeNotChange(int expectedSize) {
        // when
        List<Integer> listOfShuffleNumbers = shuffleService.generateShuffledNumbers(expectedSize);
        int actualSize = new HashSet<>(listOfShuffleNumbers).size();

        // then
        assertEquals(expectedSize, actualSize);
        assertTrue(listOfShuffleNumbers.contains(1));
        assertTrue(listOfShuffleNumbers.contains(expectedSize));
        assertTrue(listOfShuffleNumbers.contains(expectedSize / 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, 0, 1001, Integer.MAX_VALUE})
    void testGenerateShuffledNumbersWhenUseValueOutsideOfRangeThenThrowError(int incorrectSize) {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> shuffleService.generateShuffledNumbers(incorrectSize));
    }
}