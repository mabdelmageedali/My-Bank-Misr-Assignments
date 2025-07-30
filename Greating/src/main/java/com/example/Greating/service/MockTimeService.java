package com.example.Greating.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mock")
public class MockTimeService implements TimeService  {
    @Override
    public String getCurrentTime() {
        return "Mock time: 12:00:00";
    }
}
