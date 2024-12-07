package org.example.serviceshuffle.services.shuffle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ShuffleServiceImplTest {

    ShuffleService shuffleService = new ShuffleServiceImpl();

    @ParameterizedTest
    @ValueSource(ints = {3, 500, 1000})
    public void testGenerateShuffledNumbersWhenValueWithinRangeThenProducesUniqueElements(int expectedSize) {
        // when
        List<Integer> listOfShuffleNumbers = shuffleService.generateShuffledNumbers(expectedSize);
        Set<Integer> setOfShuffleNumbers = new HashSet<>(listOfShuffleNumbers);

        // then
        assertEquals(expectedSize, setOfShuffleNumbers.size());
        assertTrue(listOfShuffleNumbers.contains(1)); // check min number
        assertTrue(listOfShuffleNumbers.contains(expectedSize)); // check max number
        assertTrue(listOfShuffleNumbers.contains(expectedSize / 2)); // check middle number
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, 0, 1001, Integer.MAX_VALUE})
    public void testGenerateShuffledNumbersWhenValueWithinOutsideOfRangeThenProducesUniqueElements(int incorrectSize) {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> shuffleService.generateShuffledNumbers(incorrectSize));
    }
}