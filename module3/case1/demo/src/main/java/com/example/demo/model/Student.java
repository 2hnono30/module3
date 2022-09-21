package com.example.demo.model;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String phone;

    private String email;
    private String address;
    private String image;
    private String classroom;
    private String grade;
    private String specialized;

    public Student() {
    }

    public Student(int id, String name, String dob, String phone, String email, String address, String image, String classroom, String grade, String specialized) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
        this.classroom = classroom;
        this.grade = grade;
        this.specialized = specialized;
    }

    public Student(int id, String name, String dob, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Student(int id, String name, String dob, String phone, String email, String address, String image) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public Student(int id, String name, String classroom, String grade, String specialized) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
        this.grade = grade;
        this.specialized = specialized;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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