package com.myZodiac.blogMyZodiac.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;

    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {
    }

    public Country(String nameParam) {
        this.name = nameParam;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
