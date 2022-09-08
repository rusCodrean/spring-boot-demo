package com.garmin.springbootdemo.service.impl;

import com.garmin.springbootdemo.api.DreamRunDto;
import com.garmin.springbootdemo.service.DemoService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DemoServiceImpl implements DemoService {

    // A runner has run the same 5km course several times. These are the recorded values for each race
    // TODO make a database design for the below data.
    static String[] race1 = new String[]{"4:12", "4:51", "4:04", "5:00", "4:39"};
    static String[] race2 = new String[]{"4:10", "4:31", "4:04", "5:01", "5:38"};
    static String[] race3 = new String[]{"4:30", "4:41", "4:34", "4:40", "4:30"};
    static String[] race4 = new String[]{"4:42", "4:21", "4:05", "4:30", "4:51"};
    static String[] race5 = new String[]{"4:50", "4:52", "4:12", "4:50", "4:22"};

    public DreamRunDto getDreamRun(Long userId) {
        List<List<String>> allRunValues = Arrays.asList(Arrays.asList(race1), Arrays.asList(race2), Arrays.asList(race3), Arrays.asList(race4), Arrays.asList(race5));

        TreeMap<Integer, LocalTime> bestRunValuePerLap = new TreeMap<>();
        for (int i = 0; i < allRunValues.size(); i++) {
            List<String> runValueList = allRunValues.get(i);
            bestRunValuePerLap.put(i, runValueList.stream()
                    .map("00:0"::concat)
                    .map(LocalTime::parse)
                    .min(Comparator.comparing(rv -> rv)).orElse(null));
        }

        // populates the dream values and total dream run
        AtomicInteger totalMinutes = new AtomicInteger();
        AtomicInteger totalSeconds = new AtomicInteger();
        DreamRunDto dreamRunDto = new DreamRunDto();
        bestRunValuePerLap.forEach((key, value) -> {
            totalMinutes.addAndGet(value.getMinute());
            totalSeconds.addAndGet(value.getSecond());

            dreamRunDto.addDreamValues(value.toString());
        });

        String dreamRunTotal = totalMinutes + ":" + totalSeconds;
        dreamRunDto.setDreamRunTotal(dreamRunTotal);

        return dreamRunDto;
    }

    // TODO write a method that finds first non-repeated character in a String. Write a Unit Test to demonstrate it works as expected.

    // TODO Create a method that returns a property defined in the application.property file.
}
