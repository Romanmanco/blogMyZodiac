package com.myZodiac.blogMyZodiac.repo;

import com.myZodiac.blogMyZodiac.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {

}
