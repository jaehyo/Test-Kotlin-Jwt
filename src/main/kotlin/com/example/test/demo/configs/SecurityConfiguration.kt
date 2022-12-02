package com.example.test.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.http.HttpMethod
import io.jsonwebtoken.Jwt
import com.example.test.demo.JwtAuthenticationEntryPoint

@Configuration
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

    @Bean
    fun corsConfigurationSource() : CorsConfigurationSource {
        
        var configuration = CorsConfiguration()
        configuration.addAllowedOrigin("*")
        configuration.allowedMethods = listOf( 
            HttpMethod.GET.name , 
            HttpMethod.POST.name ,
            HttpMethod.DELETE.name,
            HttpMethod.PUT.name,
            HttpMethod.OPTIONS.name,
            HttpMethod.PATCH.name,
            HttpMethod.HEAD.name
            )
        configuration.addAllowedHeader("*")
        configuration.allowCredentials = true
        configuration.maxAge = 3600L

        var source : UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()

        source.registerCorsConfiguration("/**", configuration)

        return source
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder
    {
        return BCryptPasswordEncoder()
    }
}