package com.example.controller;

import com.example.entity.Objects;
import com.example.entity.Queries;
import com.example.service.ISearchService;
import com.example.service.ex.ObjectsNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search" )
@Api(tags= "搜索分类",description = "")
public class SearchController extends BaseController{
    @Autowired
    private ISearchService searchService;
    @RequestMapping(value="/searchByPage",method = RequestMethod.GET)
    @ApiOperation(value="搜索物品")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=7001,message = "商品名不存在"),
    })
    public JsonResult<List<Objects>> search(String search,Integer page){
        Queries queries=new Queries();
        queries.setSearch(search);
        //****此处可修改一页显示数量
        queries.setSize(5);
        queries.setPage(queries.getSize()*page);
        List<Objects> list=searchService.getObjectsBySearch(queries);
        if(list==null||list.isEmpty())
            throw new ObjectsNotFoundException();
        return new JsonResult<>(OK,list);
    }
    @RequestMapping(value = "/searchByType",method =RequestMethod.GET)
    @ApiOperation(value="获取分类物品")
    @ApiResponses({
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=7001,message = "商品名不存在"),
    })
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
