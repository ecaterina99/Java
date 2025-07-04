package com.link.model;

public class Student {

    private String sid;

    private String firstName;

    private String lastName;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student(){
    }


    public Student(String sid, String firstName, String lastName){
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override

    public String toString() {
        return firstName + " " + lastName + " " + sid;
    }

}