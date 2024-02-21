package com.example.quiz;
public class Users
{ String mail;
    String pass;
    String name;

    String refercode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefercode() {
        return refercode;
    }

    public void setRefercode(String refercode) {
        this.refercode = refercode;
    }

    public Users()
    {  }

    public Users(String mail, String pass, String name, String refercode) {
        this.mail = mail;
        this.pass = pass;
        this.name=name;
        this.refercode=refercode;

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



}
