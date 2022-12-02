package com.example.test.demo

class JwtRequest ( email : String , password : String )  {
    var email : String = email
    var password : String = password
}

class UserRegDto{

    var password : String ? = null
    var name : String ? = null
    var email : String ? = null

    constructor( name : String  ) 
    {
        this.name = name
    }

    constructor( name : String , email : String ) : this(name )
    {
        this.email = email
    }
    constructor( name : String , email : String , password : String ) : this(name , email )
    {
        this.password = password
    }

}