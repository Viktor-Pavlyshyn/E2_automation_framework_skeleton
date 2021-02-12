package com.epam.config;

//TODO Interface is not used to store constant for external usage. Use Enum or move to class, where they needed
public interface WaitTime {
    int IMPLICITLY_TIME = 50;
    int WAIT_WITH_TIMEOUT = 60;
    int POLLING_EVERY_TIME = 5;
}
