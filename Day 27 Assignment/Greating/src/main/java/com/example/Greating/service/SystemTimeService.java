package com.example.Greating.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Primary
public class SystemTimeService implements TimeService {
    @Override
    public String getCurrentTime() {
        return "System time: " + LocalTime.now();
    }
}
