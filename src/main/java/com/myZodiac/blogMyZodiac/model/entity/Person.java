package com.myZodiac.blogMyZodiac.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Roman Manko
 * @version 1.1
 */

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String address;

    public Person(String firstNameParam, String lastNameParam, String loginParam, String emailParam, String addressParam){
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
        this.login = loginParam;
        this.email = emailParam;
        this.address = addressParam;
    }
}