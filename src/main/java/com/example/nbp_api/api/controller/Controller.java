package com.example.nbp_api.api.controller;

import com.example.nbp_api.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/AvgExchange")
    public double AvgExchange(@RequestParam String date, @RequestParam String currencyCode){

        return Service.AvgExchange(currencyCode, date);

    }

    @GetMapping("/MinMax")
    public String MinMax(@RequestParam int lastQuotations, @RequestParam String currencyCode){

        return Service.MinMax(currencyCode, lastQuotations);

    }

    @GetMapping("/DifferenceBuyAsk")
    public String DifferenceBuyAsk(@RequestParam int lastQuotations, @RequestParam String currencyCode){

        return Service.DifferenceBuyAsk(currencyCode, lastQuotations);

    }

}
