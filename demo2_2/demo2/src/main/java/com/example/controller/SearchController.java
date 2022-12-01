package com.example.controller;

import com.example.entity.Objects;
import com.example.entity.Queries;
import com.example.service.ISearchService;
import com.example.service.ex.ObjectsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search" )
public class SearchController extends BaseController{
    @Autowired
    private ISearchService searchService;
    @RequestMapping(value="searchByPage")
    public JsonResult<List<Objects>> search(String search,Integer page){
        Queries queries=new Queries();
        queries.setSearch(search);
        //****此处可修改一页显示数量
        queries.setSize(5);
        queries.setPage(queries.getSize()*page);
        List<Objects> list=searchService.getObjectsBySearch(queries);
        return new JsonResult<>(OK,list);
    }
    @RequestMapping(value = "searchByType")
    public JsonResult<List<Objects>> searchByType(String type,Integer page){
        Queries queries=new Queries();
        queries.setSearch(type);
        queries.setSize(5);
        queries.setPage(queries.getSize()*page);
        List<Objects> list=searchService.getObjectsByType(queries);
        if(list==null||list.isEmpty())
            throw new ObjectsNotFoundException();
        return new JsonResult<>(OK,list);
    }
}
