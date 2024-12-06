package org.example.serviceshuffle.services.shuffle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ShuffleServiceImpl implements ShuffleService {
    private final Random random = new Random();

    @Override
    public List<Integer> generateShuffledNumbers(int size) {
        if (size < 1 || size > 1000) {
            throw new IllegalArgumentException("Size must be between 1 and 1000");
        }

        List<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(i + 1);
            int number = random.nextInt(i + 1);
            Collections.swap(numbers, i, number);
        }

        return numbers;
    }
}
