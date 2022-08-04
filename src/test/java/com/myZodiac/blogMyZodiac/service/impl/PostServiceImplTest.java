package com.myZodiac.blogMyZodiac.service.impl;

import com.myZodiac.blogMyZodiac.mapper.PostMapper;
import com.myZodiac.blogMyZodiac.model.dto.PostDTO;
import com.myZodiac.blogMyZodiac.model.entity.Post;
import com.myZodiac.blogMyZodiac.repo.PostRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Roman Manko
 * @version 1.1
 */

@ExtendWith(SpringExtension.class)
public class PostServiceImplTest {

    private static final Long POST_ID = 1L;
    private static final String POST_TITLE = "какой-то текст";
    private static final String POST_ANONS = "анонс поста";
    private static final String POST_FULL_TEXT = "полный текст статьи";
    private static final int POST_VIEWS = 1;
    private static final Post POST = new Post(
            POST_ID,
            POST_TITLE,
            POST_ANONS,
            POST_FULL_TEXT,
            POST_VIEWS
    );
    private static final PostDTO POST_DTO = new PostDTO(
            POST_TITLE,
            POST_ANONS,
            POST_FULL_TEXT
    );

    @Spy
    @InjectMocks
    private PostServiceImpl service;

    @Mock
    private PostRepo repository;

    @Mock
    PostMapper postMapper;

    @Test
    public void getPostDtoByIdTest () throws Exception {
        Mockito.when(repository.getById(POST_ID))
                .thenReturn(POST);
        Mockito.when(postMapper.entityToDto(POST))
                .thenReturn(POST_DTO);

        PostDTO entryById = service.getPostDtoById(POST_ID);

        assertEquals(POST_DTO, entryById);
    }
}
