package com.yalo.demo.controller;


import com.yalo.demo.entity.PhoneEntity;
import com.yalo.demo.entity.Response;
import com.yalo.demo.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService service;

    /* Main end point
       return List<PhoneEntity>
     */
    @GetMapping("/phone-check")
    public List<PhoneEntity> checkNumbers () throws InterruptedException {
         return service.checkNumbers();

    }
}
