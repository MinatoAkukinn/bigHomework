package com.example.mapper;

import com.example.entity.Objects;
import com.example.entity.Queries;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    Integer countBySearch(Queries queries);
    List<Objects> selectBySearch(Queries queries);
    List<Objects> selectByType(Queries queries);
}
