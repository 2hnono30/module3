package com.example.casestudy.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private int idCountry;

    public Customer() {
    }

    public Customer(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, String name, String email, String address, int idCountry) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.idCountry = idCountry;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    @NotEmpty(message = "Name khong de trong")
//    @Length(min = 3, max = 10, message = "Do dai Name tu 3 den 10 ki tu")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @Email(message = "Email khong hop le")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}