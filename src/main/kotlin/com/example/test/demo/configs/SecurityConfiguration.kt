package com.example.test.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.context.annotation.Bean
import io.jsonwebtoken.Jwt.
import com.example.test.demo.JwtAuthenticationEntryPoint

@SpringBootApplication
class KotlinSecurityApplication

class SecurityConfiguration  {

    var unauthorizedHandler : JwtAuthenticationEntryPoint ?= null

    @Bean
    fun filterChain( http : HttpSecurity ) : SecurityFilterChain {
        http.cors().and()
            .csrf().disable()
            .authorizeRequests().antMatchers("/authenticate","/api/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(unauthorizedHandler)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return http.build()
    }
}