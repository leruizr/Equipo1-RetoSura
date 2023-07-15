package com.ken.newsapp.requests;

import lombok.Data;

@Data
public class NewsRequest {

    private String query;

    private String language;

    private Integer pageSize;
}
