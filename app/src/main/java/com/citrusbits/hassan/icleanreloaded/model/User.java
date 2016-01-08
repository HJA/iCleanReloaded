package com.citrusbits.hassan.icleanreloaded.model;

import java.io.Serializable;

public class User implements Serializable {

    private long id;
    private String username;
    private String email;
    private String phone;
    private String zip;
    private String type;
    private String promo;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPromo() {
        return promo;
    }
    public void setPromo(String promo) {
        this.promo = promo;
    }
}
