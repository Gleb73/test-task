package org.example.serviceshuffle.controllers;

import org.example.serviceshuffle.services.logs.LogService;
import org.example.serviceshuffle.services.shuffle.ShuffleService;
import org.example.serviceshuffle.services.shuffle.ShuffleServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shuffle")
public class ShuffleController {
    private final ShuffleService shuffleService;
    private final LogService logService;

    public ShuffleController(ShuffleServiceImpl shuffleService, LogService logService) {
        this.shuffleService = shuffleService;
        this.logService = logService;
    }

    @PostMapping
    public List<Integer> shuffleAndLog(@RequestBody int number) {
        List<Integer> numbers = shuffleService.generateShuffledNumbers(number);
        logService.logger(numbers);
        return numbers;
    }
}
