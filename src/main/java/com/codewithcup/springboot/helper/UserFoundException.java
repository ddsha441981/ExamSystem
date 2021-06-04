package com.codewithcup.springboot.helper;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super("User with this username is already there in database!! Try with another one!!");
    }
    public UserFoundException(String msg){
        super(msg);
    }
}
