package com.myZodiac.blogMyZodiac.repo;

import com.myZodiac.blogMyZodiac.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

}