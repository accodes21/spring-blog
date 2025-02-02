package com.jetbrains.marco.blog.service;

import org.springframework.stereotype.Service;

import com.jetbrains.marco.blog.model.Blog;
import com.jetbrains.marco.blog.repository.BlogRepository;

@Service
public class BlogService {
    
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Iterable<Blog> get(){
        return blogRepository.findAll();
    }

    public Blog get(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }
}
