package com.myZodiac.blogMyZodiac.service.impl;

import com.myZodiac.blogMyZodiac.mapper.PostMapper;
import com.myZodiac.blogMyZodiac.model.dto.PostDTO;
import com.myZodiac.blogMyZodiac.model.entity.Post;
import com.myZodiac.blogMyZodiac.repo.PostRepo;
import com.myZodiac.blogMyZodiac.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Класс реализует методы интерфейса PostService.
 * Аннотация @Service помечает что компонент содерожит бизнес-логику приложения.
 * Аннотация @Autowired используется для проводки связи между объектами.
 *
 * @author Roman Manko
 * @version 1.1
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo repository;

    @Autowired
    PostMapper postMapper;

    @Override
    public boolean postByIdIsPresent(Long postId) {
        return repository.existsById(postId);
    }

    @Override
    public PostDTO getPostDtoById(Long postId) throws Exception {
        Optional<Post> optionalPost = repository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            PostDTO postDTO = postMapper.entityToDto(post);
            return postDTO;
        } else {
            throw new Exception("post by id not found");
        }
    }
}
