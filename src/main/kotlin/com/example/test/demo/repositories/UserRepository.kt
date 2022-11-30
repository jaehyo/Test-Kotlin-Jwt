package com.example.test.demo

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository

import com.example.test.demo.User

interface UserRepository : JpaRepository<User , Long> {
    fun findByName( name : String ) : Optional<User>

    fun findByEmail ( email : String ) : Optional<User>
}