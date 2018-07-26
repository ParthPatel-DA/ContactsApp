package com.example.jswn.contactsapp;

/**
 * Created by JSWN on 23-03-2018.
 */

public class MyData {
    private String Name;
    private String PhoneNo;
    private String Email;

    public MyData(){

    }

    public MyData(String name, String phoneNo, String email) {
        this.Name = name;
        this.PhoneNo = phoneNo;
        this.Email = email;
    }

    public String getName() {
        return this.Name;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
