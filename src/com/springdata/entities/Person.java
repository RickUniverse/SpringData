package com.springdata.entities;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lijichen
 * @date 2020/12/2 - 14:27
 */
@Entity
@Table(name = "jpa_person")
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private Address address;
    private Integer addressId;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", addressId=" + addressId +
                '}';
    }

    @Column(name = "ADD_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @JoinColumn(name = "ADDRESS_ID")
    @ManyToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}
