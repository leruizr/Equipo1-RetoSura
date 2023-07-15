package com.ken.newsapp.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document(collection = "news")
public class New {

    @Id
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

}
