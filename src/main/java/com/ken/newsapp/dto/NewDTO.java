package com.ken.newsapp.dto;

import com.ken.newsapp.entities.New;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewDTO {

    private String id;

    private String title;

    private String content;

    private String url;

    private String source;

    private LocalDate date;

    private String imageUrl;

    private String tag;

    private String lang;

    private String author;

    public NewDTO(New n){
        this.id = n.getId();
        this.title = n.getTitle();
        this.content = n.getContent();
        this.url = n.getUrl();
        this.source = n.getSource();
        this.date = n.getDate();
        this.imageUrl = n.getImageUrl();
        this.tag = n.getTag();
        this.lang = n.getLang();
        this.author = n.getAuthor();
    }
}
