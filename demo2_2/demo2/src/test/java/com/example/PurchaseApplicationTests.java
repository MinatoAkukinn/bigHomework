package com.example;

import com.example.entity.Purchase;
import com.example.mapper.PurchaseMapper;
import com.example.service.ex.InsertException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class PurchaseApplicationTests {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Test
    public void insert(){
        Purchase purchase=new Purchase();
        purchase.setPurchaseStatus(0);
        purchase.setStartTime(new Date());
        purchase.setEndTime(new Date());
        purchase.setObjectId(3);
        purchase.setUserId(1);
        purchase.setTotalPrice(2.99);
        Integer row=purchaseMapper.insert(purchase);
        if(row!=1){
            throw new InsertException("插入失败");
        }

    }
}
