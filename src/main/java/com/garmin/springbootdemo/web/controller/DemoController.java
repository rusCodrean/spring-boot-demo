package com.garmin.springbootdemo.web.controller;

import com.garmin.springbootdemo.api.DreamRunDto;
import com.garmin.springbootdemo.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.garmin.springbootdemo.web.mapping.DemoRequestMappings.DEMO;

@Controller
@RequestMapping(DEMO)
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(value = "/dream-run/user/{userId}")
    public ResponseEntity<DreamRunDto> getDreamRunForUser(@PathVariable Long userId) {
        DreamRunDto dreamRun = demoService.getDreamRun(userId);

        if (dreamRun != null) {
            return new ResponseEntity<>(dreamRun, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.GONE);
    }

    // TODO create a POST method structure that takes a request body (as json) for a specific user which is identified by a userId. Let's say
    //  this method saves the values recorded for a race, from the above example.
}
