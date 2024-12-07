package com.ps.models;

public class Patron {
    private int patron_id;
    private String name;
    private String email;
    private String phone;

    public Patron(){}

    public Patron (int patron_id,String name,String email,String phone){
        this.patron_id = patron_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getPatron_id (){
        return this.patron_id;
    }
    public void setPatron_id(int patron_id){
        this.patron_id = patron_id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "patron_id=" + patron_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
