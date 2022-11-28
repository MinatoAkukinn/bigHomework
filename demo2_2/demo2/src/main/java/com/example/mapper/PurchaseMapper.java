package com.example.mapper;

import com.example.entity.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    Integer insert(Purchase purchase);
    List<Purchase> getPurchasesByUserId(Integer userId);
}
