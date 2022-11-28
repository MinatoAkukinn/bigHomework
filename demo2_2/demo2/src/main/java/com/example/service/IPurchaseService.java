package com.example.service;

import com.example.entity.Purchase;

import java.util.List;

public interface IPurchaseService {
     Purchase create(Purchase purchase);

     List<Purchase> getPurchasesByUserId(Integer userId);
}
