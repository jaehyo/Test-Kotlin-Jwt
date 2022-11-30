package com.example.test.demo

import org.springframework.stereotype.Service
import com.example.test.demo.User

@Service
class UserService {
    fun findById( id : String ) : User {
        var user = User("" , "" , "")

        return user
    } 
}