package com.example.test.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.Table
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority
import com.example.test.demo.BaseTime

@Entity
@Table(name="USER")
class User( name : String , email : String , m_password : String ) : BaseTime() ,  UserDetails  {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    var id : Long ? = null
    @Column( nullable = false )
    var name : String = name

    @Column( nullable = false , unique = true  )
    var email : String = email

    @Column( nullable = false )
    var m_password : String = m_password

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String {
        return m_password
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}