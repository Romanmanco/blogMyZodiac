package com.myZodiac.blogMyZodiac.service;

import com.myZodiac.blogMyZodiac.model.dto.PostDTO;

/**
 * Интерфейс содержит методы для сущьности Post, которые нужны для манипуляций с данными.
 *
 * @author Roman Manko
 * @version 1.1
 */

public interface PostService {

    boolean postByIdIsPresent(Long postId);

    PostDTO getPostDtoById(Long postId) throws Exception;

}
