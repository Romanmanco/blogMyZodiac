package com.myZodiac.blogMyZodiac.service;

import com.myZodiac.blogMyZodiac.dto.PostDTO;
import com.myZodiac.blogMyZodiac.model.Post;
import com.myZodiac.blogMyZodiac.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public boolean postByIdIsPresent(Long postId){
        return postRepo.existsById(postId);
    }

    public PostDTO getPostDtoById(Long postId) throws Exception {
        Optional<Post> optionalPost = postRepo.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            PostDTO postDTO = entity2dto(post);
            return postDTO;
        }else {
            throw new Exception("post by id not found");
        }
    }

    public PostDTO entity2dto(Post entity) {
        PostDTO dto = new PostDTO();
        dto.setFullText(entity.getFullText());
        dto.setAnons(entity.getAnons());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
