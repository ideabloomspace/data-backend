package com.data.entry.kendra.controller;

import com.data.entry.kendra.model.DataEntryDetails;
import com.data.entry.kendra.services.ISendSms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin
@Slf4j
public class SendSmsController {


    @Autowired
    private ISendSms sendSms;


    @PostMapping(path = "/v1/sendsms")
    public void sendSms(
           @RequestBody DataEntryDetails dataEntryDetails) {
            sendSms.sendSms(dataEntryDetails);
    }

    @GetMapping(path = "/v1/ping")
    public String ping() {
        return "hello, I'm working";
    }


}
