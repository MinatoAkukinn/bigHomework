package com.example.service;

import com.example.entity.Objects;
import com.example.entity.Queries;

import java.util.List;

public interface ISearchService {
    Integer getCountBySearch(Queries queries);
    List<Objects> getObjectsBySearch(Queries queries);

    List<Objects> getObjectsByType(Queries queries);
}
