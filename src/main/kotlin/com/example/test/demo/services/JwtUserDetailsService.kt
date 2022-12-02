package com.example.test.demo

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.apache.catalina.Role
import com.example.test.demo.JwtRequest

@Service
class JwtUserDetailsService(private val userRepository : UserRepository , private val passwordEncoder : PasswordEncoder) : UserDetailsService
{
    
    //@Autowired
    //private lateinit var userRepository : UserRepository
    override fun loadUserByUsername ( email : String ) : UserDetails{
        var user = userRepository.findByEmail(email).orElseThrow{ UsernameNotFoundException(email) }

        var grantedAuthorities = mutableSetOf<GrantedAuthority>()
        
        //grantedAuthorities.add( SimpleGrantedAuthority(Role.ADMIN.getValue()) )
        return user
    }

    public fun authenticateByEmailAndPassword( request : JwtRequest ) : User
    {
        var user = userRepository.findByEmail(request.email).orElseThrow{ UsernameNotFoundException(request.email) }

        if (!passwordEncoder.matches(request.password, user.password ) )
        {
            BadCredentialsException("Password not matched")
        }

        return user
    }
}