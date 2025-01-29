package com.jetbrains.marco.blog.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jetbrains.marco.blog.model.Blog;

@RestController
public class BlogController {

    private Map<Integer, Blog> db = new HashMap<>(){{
        put(1, new Blog(1, "First Blog", "This is my first blog"));
    }};

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/blog")
    public Collection<Blog> get(){
        return db.values();
    }

    @GetMapping("/blog/{id}")
    public Blog get(@PathVariable Integer id){
        Blog blog = db.get(id);
        if(blog == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found");
        }
        return blog;
    }

    @DeleteMapping("/blog/{id}")
    public void delete(@PathVariable Integer id){
        Blog blog = db.remove(id);
        if(blog == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found");
        }
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        blog.setId(db.size() + 1);
        db.put(blog.getId(), blog);
        return ResponseEntity.ok(blog);
    }
    
}
