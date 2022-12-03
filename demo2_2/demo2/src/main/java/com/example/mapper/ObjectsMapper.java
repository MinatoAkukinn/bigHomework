package com.example.mapper;

import com.example.entity.Objects;
import com.example.entity.comments;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.List;
@Mapper
public interface ObjectsMapper {
    List<Objects> findNewListByObjectType(String objectType, String objectType2);
    Objects findObjectsByObjectId(Integer ObjectId);
    List<comments> findCommentsByObjectId(Integer objectId);

    Integer Insert(Objects object);
    List<Objects> findObjectListByObjectType(String objectType);

    Integer UpdateObjectById(Objects object);

    Integer findUserIdByObjectId(Integer objectId);

    List<Objects> finObjectsByUserId(Integer userId);
}
