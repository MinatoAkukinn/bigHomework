package com.example.entity;

import lombok.Data;

@Data
public class Queries {
    private String search;
    private Integer page;
    private Integer size;

//    private Integer offset=size*page;

}
