package com.jetbrains.marco.blog.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jetbrains.marco.blog.model.Blog;
import com.jetbrains.marco.blog.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/blog")
    public Iterable<Blog> get(){
        return blogService.get();
    }

    @GetMapping("/blog/{id}")
    public Blog get(@PathVariable Integer id){
        Blog blog = blogService.get(id);
        if(blog == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found");
        }
        return blog;
    }

    @DeleteMapping("/blog/{id}")
    public void delete(@PathVariable Integer id){
        blogService.remove(id);
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog savedBlog = blogService.save(blog);
        return ResponseEntity.ok(savedBlog);
    }
    
}
