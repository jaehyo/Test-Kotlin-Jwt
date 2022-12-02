package com.example.test.demo

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetailsService
import springfox.documentation.service.Response
import javax.validation.Valid
import com.example.test.demo.JwtRequest
import com.example.test.demo.BaseResponseCode

const val URL_PREFIX  = "/auth"

@RestController
@RequestMapping(URL_PREFIX)
class AuthContoller( private val jwtUserDetailsService : UserDetailsService , private val userService : UserService  ){
    
    @PostMapping()
    fun login( @Valid @RequestBody request : JwtRequest) : ResponseEntity<Any?> {

        var jwtUserService = jwtUserDetailsService as JwtUserDetailsService
        var user = jwtUserService.authenticateByEmailAndPassword(request)

        if ( user == null )
            throw BaseException( BaseResponseCode.USER_NOT_FOUND )

        //var resultRes = Response.Builder.
        return ResponseEntity.ok(BaseResponseCode.OK)
    }

    @PostMapping("/register")
    fun register( @RequestBody userRegDto : UserRegDto ) : UserRegDto {
        if (  userService.existsUser( userRegDto.email as String ) ){
            throw BaseException(BaseResponseCode.DUPLICATE_EMAIL )
        }
        return userService.registUser( userRegDto )
    }
}

