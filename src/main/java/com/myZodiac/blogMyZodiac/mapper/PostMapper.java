package com.myZodiac.blogMyZodiac.mapper;

import com.myZodiac.blogMyZodiac.model.entity.Post;
import com.myZodiac.blogMyZodiac.model.dto.PostDTO;
import org.springframework.stereotype.Component;

/**
 * Класс используется для преобразования сущьности в dto.
 * Аннотация @Component позволяет Spring определять компонент программы.
 *
 * @return возвращает dto.
 *
 * @author Roman Manko
 * @version 1.0
 */

@Component
public class PostMapper {

    public PostDTO entityToDto(Post entity) {
        PostDTO dto = new PostDTO();
        dto.setFullText(entity.getFullText());
        dto.setAnons(entity.getAnons());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
