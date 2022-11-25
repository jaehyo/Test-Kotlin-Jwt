package com.example.test.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestContoller{
    @GetMapping()
    fun index () : String {
        println("HI User")
        return "Hello Spring Kotlin"
    }

    @GetMapping("/HI")
    fun test () : String {
        return "test"
    }
}