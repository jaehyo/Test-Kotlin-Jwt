package com.example.test.demo

import org.springframework.stereotype.Service
import org.springframework.security.crypto.password.PasswordEncoder
import com.example.test.demo.User

@Service
class UserService ( private val userRepository : UserRepository , private val passwordEncoder : PasswordEncoder  ) {
    fun findById( id : String ) : User {
        var user = User("" , "" , "")

        return user
    }
    fun existsUser ( email : String ) : Boolean {
         return userRepository.existsByEmail(email)
    }

    fun registUser( userRegDto : UserRegDto ) : UserRegDto
    {
        var user = User( userRegDto.name?:"" , userRegDto.email?:"" ,  passwordEncoder.encode(userRegDto.password)  )

        userRepository.save(user)

        return UserRegDto( userRegDto.name?:"" , userRegDto.email?:"" )
    }
}