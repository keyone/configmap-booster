package com.bmo.configmapbooster.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    @Autowired
    private MessageProperties properties;

    @RequestMapping("/api/greeting")
    public Message greeting(@RequestParam(value = "name", defaultValue = "Banana") String name) {
        Objects.requireNonNull(properties.getMessage(), "Greeting message was not set in the properties");

        String message = String.format(properties.getMessage(), name);
        return new Message(message);
    }
}
