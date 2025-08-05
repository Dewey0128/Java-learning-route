package com.george.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DateController {

    private final Date date;

    @Autowired
    DateController(Date date){
        this.date = date;
    }

    @GetMapping("/date")
    public Date printDate(){
        return this.date;
    }
}
