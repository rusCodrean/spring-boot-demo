package com.garmin.springbootdemo.service;

import com.garmin.springbootdemo.api.DreamRunDto;

public interface DemoService {
    /**
     * This method is looking to put together the runner's 'dream run', which consists of the best time per lap from all the runs.
     *  Computes the best time for each lap(1 - 5) and gives the total time of the user's 'dream run'.
     *
     * @param userId the userId for which to return the dream run values
     * @return the dream run values and total
     */
    DreamRunDto getDreamRun(Long userId);
}
