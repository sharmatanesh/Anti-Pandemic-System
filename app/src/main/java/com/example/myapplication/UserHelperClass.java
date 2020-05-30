package com.example.myapplication;

public class UserHelperClass {

    String Name,Number,Adderess,Status,Email;

    public UserHelperClass(String email, String name, String number, String adderess) {
        Name = name;
        Number = number;
        Adderess = adderess;
        Email = email;
    }
    public UserHelperClass()
    {

    }
    public void setEmail(String email){Email = email;}

    public String getEmail(){return Email;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAdderess() {
        return Adderess;
    }

    public void setAdderess(String adderess) {
        Adderess = adderess;
    }

}
