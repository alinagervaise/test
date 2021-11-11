package com.example.bananesexport.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "costumer", uniqueConstraints= @UniqueConstraint(columnNames={"name", "address", "zip_code", "city", "country"}))
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "ADDRESS", nullable = false, length = 150)
    private String  address;

    @Column(name = "ZIP_CODE", nullable = false, length = 5)
    private String zip_code;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "costumer")
    private Set <Purchase> purchases = new HashSet<Purchase>(0);

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

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Purchase> getPurshases() {
        return purchases;
    }

    public void setPurshases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
}
