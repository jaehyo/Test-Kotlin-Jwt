
package com.example.test.demo

import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint{
    
    override fun commence( request : HttpServletRequest , response : HttpServletResponse , e : AuthenticationException   ) {
        response.sendError( HttpServletResponse.SC_UNAUTHORIZED , "UnAuthorized" )
    }
}