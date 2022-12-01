package com.example.service.impl;

import com.example.entity.Objects;
import com.example.entity.Queries;
import com.example.mapper.SearchMapper;
import com.example.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService {
    @Autowired
    private SearchMapper searchMapper;


    @Override
    public Integer getCountBySearch(Queries queries) {
        return searchMapper.countBySearch(queries);
    }

    @Override
    public List<Objects> getObjectsBySearch(Queries queries) {
        return searchMapper.selectBySearch(queries);
    }

    @Override
    public List<Objects> getObjectsByType(Queries queries) {
        return searchMapper.selectByType(queries);
    }
}
