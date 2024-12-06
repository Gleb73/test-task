package org.example.serviceshuffle.services.logs;

import org.example.serviceshuffle.api.LogApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    private final LogApi logApi;

    public LogServiceImpl(LogApi logApi) {
        this.logApi = logApi;
    }

    @Override
    public void logger(List<Integer> shuffleNumbers) {
        logApi.post(shuffleNumbers);
    }
}
