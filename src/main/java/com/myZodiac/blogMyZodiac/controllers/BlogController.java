package com.myZodiac.blogMyZodiac.controllers;

import com.myZodiac.blogMyZodiac.model.Post;
import com.myZodiac.blogMyZodiac.repo.PostRepo;
import com.myZodiac.blogMyZodiac.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogController {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String blog(Model model){
        Iterable<Post> posts = postRepo.findAll();
        //добавили коллекцию в модель
        model.addAttribute("posts", posts);
        //отправили модель и вью в браузер
        return "blogMain";
    }

    @GetMapping("/blogAdd")
    public String blogAdd(Model model){
        return "blogAdd";
    }

    @PostMapping("/blogAdd")
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String fullText,
                              Model model){
        Post post = new Post(title, anons, fullText);
        postRepo.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long postId, Model model){
        if(!postRepo.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> postOpt = postRepo.findById(postId);
        Post post = postOpt.get();
        model.addAttribute("post", post);
        return "blogDetails";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long postId, Model model) throws Exception {
        if (!postService.postByIdIsPresent(postId)) {
            return "redirect:/blog";
        }
        model.addAttribute("post", postService.getPostDtoById(postId));
        return "blogEdit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long postId,
                                 @RequestParam String title,
                                 @RequestParam String anons,
                                 @RequestParam String fullText,
                                 Model model){
        Post post = postRepo.findById(postId).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        postRepo.save(post);

        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long postId, Model model){
        Post post = postRepo.findById(postId).orElseThrow();
        postRepo.delete(post);

        return "redirect:/blog";
    }

}
//todo прочитать про паттерн DTO
//todo прочитать про паттерн facade
//todo кастомизация ошибок