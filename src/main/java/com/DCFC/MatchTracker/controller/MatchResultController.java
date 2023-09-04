package com.DCFC.MatchTracker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/match/")
public class MatchResultController {

    @GetMapping("/")
    public void matchResults() {

    }
}
