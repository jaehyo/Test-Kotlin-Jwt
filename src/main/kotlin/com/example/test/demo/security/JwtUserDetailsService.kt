package com.example.test.demo

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class JwtUserDetailsService(private val userRepository : UserRepository) : UserDetailsService
{
    //@Autowired
    //private lateinit var userRepository : UserRepository
    override fun loadUserByUsername ( email : String ) : UserDetails{
        var user = userRepository.findByEmail(email).orElseThrow{ () ->throw UsernameNotFoundException(email) }

        var grantedAuthorities : Set<GrantedAuthority>

    grantedAuthorities.add( SimpleGrantedAuthority(Role.ADMIN.getValue()) )

    }
}