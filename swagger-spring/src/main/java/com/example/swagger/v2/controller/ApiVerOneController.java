package com.example.swagger.v2.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class ApiVerOneController {
    @GetMapping("")
    public String gets() {
        return "hello world !";
    }
    @PutMapping("")
    public String update() {
        return "hello world !";
    }
    @PostMapping("")
    public String create() {
        return "hello world !";
    }
    @GetMapping("/get-one")
    public String getOne() {
        return "hello world !";
    }
    @GetMapping("/get-hello")
    public String getHello() {
        return "hello world !";
    }


}
