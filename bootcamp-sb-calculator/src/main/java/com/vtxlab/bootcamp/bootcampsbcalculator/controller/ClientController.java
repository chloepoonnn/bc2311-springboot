package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.RequestCounting;

public interface ClientController {

    @GetMapping(value = "/calculation/x/{x}/y/{y}/operation/{operation}") // ?x=10&y=9&operation=add
    String calculateByRequestParam(@RequestParam String x,
            @RequestParam String y, @RequestParam String operation);

    @PostMapping(value = "/calculation")
    String calculateByRequestBody(@RequestBody RequestCounting requestCounting);

    @GetMapping(value = "/calculation/{x}/{y}/{operation}")
    String calculateByPathVariable(@PathVariable String x,
            @PathVariable String y, @PathVariable String operation);


}
