package com.example.service.impl;

import com.example.entity.Objects;
import com.example.entity.comments;
import com.example.mapper.ObjectsMapper;
import com.example.service.IObjectsService;
import com.example.service.ex.InsertException;
import com.example.service.ex.ObjectsNotFoundException;
import com.example.service.ex.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ObjectsServiceImpl implements IObjectsService {
@Autowired
private ObjectsMapper objectMapper;
    @Override
    public List<Objects> findNewListByObjectType(String objectType, String objectType2) {
        List<Objects> list= objectMapper.findNewListByObjectType(objectType,objectType2);
        if(list==null|list.isEmpty()) throw new ObjectsNotFoundException("没找到");
        return list;
    }

    @Override
    public Objects findObjectsByObjectId(Integer objectId) {
        Objects obj=objectMapper.findObjectsByObjectId(objectId);
        return obj;
    }

    @Override
    public List<comments> findCommentsByObjectId(Integer objectId) {

        List<comments> list=objectMapper.findCommentsByObjectId(objectId);
        return null;
    }

    @Override
    public Integer Insert(Objects object) {
        object.setShelfTime(new Date());
        object.setStatus(true);
        Integer row= objectMapper.Insert(object);
        if(row==0) throw new InsertException("创建错误");
        return row;
    }

    @Override
    public List<Objects> findObjectListByObjectType(String objectType) {
        return objectMapper.findObjectListByObjectType(objectType);
    }
}
