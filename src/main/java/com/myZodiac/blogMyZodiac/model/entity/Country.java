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
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Country(String nameParam) {
        this.name = nameParam;
    }
}
