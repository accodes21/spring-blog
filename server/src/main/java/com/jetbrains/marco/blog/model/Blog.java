package com.jetbrains.marco.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;

@Table("BLOG")
public class Blog {

    @Id
    private Integer id;

    @NotEmpty
    private String title;
    private String content;

    public Blog() {
    }

    // public Blog(int id, String title, String content) {
    //     this.id = id;
    //     this.content = content;
    //     this.title = title;
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
