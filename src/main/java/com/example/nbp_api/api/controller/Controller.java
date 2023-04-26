package com.example.nbp_api.api.controller;

import com.example.nbp_api.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Controller {

    @GetMapping("/AvgExchange")
    public String AvgExchange(@RequestParam String date, @RequestParam String currencyCode){

        try {
            return Service.AvgExchange(currencyCode, date);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @GetMapping("/MinMaxExchange")
    public String MinMaxExchange(@RequestParam int lastQuotations, @RequestParam String currencyCode){
        try {
            return Service.MinMaxExchange(currencyCode, lastQuotations);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }

    }

    @GetMapping("/DifferenceBuyAsk")
    public String DifferenceBuyAsk(@RequestParam int lastQuotations, @RequestParam String currencyCode){
        try {
            return Service.DifferenceBuyAsk(currencyCode, lastQuotations);
        }
        catch(Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }

    }

}
