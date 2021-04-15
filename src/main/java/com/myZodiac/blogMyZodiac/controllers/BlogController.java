package com.myZodiac.blogMyZodiac.controllers;

import com.myZodiac.blogMyZodiac.model.Post;
import com.myZodiac.blogMyZodiac.repo.PostRepo;
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
                              @RequestParam String full_text,
                              Model model){
        Post post = new Post(title, anons, full_text);
        postRepo.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long postId, Model model){
        Optional<Post> post = postRepo.findById(postId);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "blogDetails";
    }

}
