package com.jetbrains.marco.blog.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jetbrains.marco.blog.model.Blog;

@Service
public class BlogService {
    private Map<Integer, Blog> db = new HashMap<>(){{
        put(1, new Blog(1, "First Blog", "This is my first blog"));
    }};

    public Collection<Blog> get(){
        return db.values();
    }

    public Blog get(Integer id) {
        Blog blog = db.get(id);
        if(blog == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found");
        }
        return blog;
    }

    public void remove(Integer id) {
        Blog blog = db.remove(id);
        if(blog == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found");
        }
    }

    public void save(Integer id, Blog blog) {
        blog.setId(db.size() + 1);
        db.put(id, blog);
    }
}
