package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Queries",description = "搜索分类对象")
public class Queries {
    @ApiModelProperty(value = "分类/搜索内容")
    private String search;
    @ApiModelProperty(value = "页数/从0开始")
    private Integer page;
    @ApiModelProperty(value = "每一页数量")
    private Integer size;

//    private Integer offset=size*page;

}
