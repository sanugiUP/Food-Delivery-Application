package com.example.mad_assignment;

public class Customer {
    private String cus_Name;
    private String cus_Email;
    private String cus_Password;

    public Customer(String name, String email, String password){
        this.cus_Name = name;
        this.cus_Password = password;
        this.cus_Email = email;
    }

    public String getCustomerName() { return this.cus_Name; }

    public String getCustomerPassword(){
        return this.cus_Password;
    }

    public String getCustomerEmail(){
        return this.cus_Email;
    }
}
