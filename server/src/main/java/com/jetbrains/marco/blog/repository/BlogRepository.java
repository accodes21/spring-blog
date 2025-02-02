package com.jetbrains.marco.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.jetbrains.marco.blog.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
    
}
