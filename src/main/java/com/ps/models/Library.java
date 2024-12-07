package com.ps.models;

public class Library {
    private int library_id;
    private String name;
    private String address;
    private String phone;

    public Library(){}

    public Library(int library_id,String name, String address, String phone){
        this.library_id = library_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getLibrary_id(){
        return this.library_id;
    }
    public void setLibrary_id(int library_id){
        this.library_id = library_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Library{" +
                "library_id=" + library_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
