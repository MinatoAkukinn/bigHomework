package com.example.service.impl;

import com.example.entity.Purchase;
import com.example.mapper.PurchaseMapper;
import com.example.service.IPurchaseService;
import com.example.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImpl implements IPurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Override
    public Purchase create(Purchase purchase) {
        Integer row=purchaseMapper.insert(purchase);
        if(row!=1) throw new InsertException("插入失败");
        return purchase;
    }

    @Override
    public List<Purchase> getPurchasesByUserId(Integer userId) {
        return purchaseMapper.getPurchasesByUserId(userId);
    }
}
