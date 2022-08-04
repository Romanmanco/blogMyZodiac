package com.myZodiac.blogMyZodiac.repo;

import com.myZodiac.blogMyZodiac.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Manko
 * @version 1.1
 */

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {

}
