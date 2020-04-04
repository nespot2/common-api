package com.nespot2.commonapi.profile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/02/16
 **/
@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    @GetMapping
    public String hello() {
        return "hello";
    }

}
