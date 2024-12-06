package org.example.serviceshuffle.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class LogApi {
    private final RestTemplate restTemplate;

    @Value("${service.log.url}")
    private String logServiceUrl;

    public LogApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async(value = "asyncExecutor")
    public void post(List<Integer> shuffleNumbers) {
        restTemplate.postForEntity(logServiceUrl, shuffleNumbers, Void.class);
    }
}
