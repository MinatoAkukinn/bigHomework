package com.example.service;

import com.example.entity.Objects;
import com.example.entity.comments;

import java.util.List;

public interface IObjectsService {
    List<Objects> findNewListByObjectType(String objectType, String objectType2);
    Objects findObjectsByObjectId(Integer objectId);
    List<comments> findCommentsByObjectId(Integer objectId);
    Integer Insert(Objects object);
    List<Objects> findObjectListByObjectType(String objectType);
    Integer updateObject(Objects objects);

    Integer findUserIdByObjectId(Integer objectId);

    List<Objects> findObjectListByUserId(Integer userId);
}
