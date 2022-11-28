package com.example.controller;

import com.example.entity.Purchase;
import com.example.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping(value = "/purchase" )
public class PurchaseController extends BaseController{
    @Autowired
    private IPurchaseService purchaseService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public JsonResult<Purchase> create(HttpSession session,Purchase purchase){
        Integer userId=getUserIdFromSession(session);
        purchase.setUserId(userId);
        Purchase result=purchaseService.create(purchase);
        return new JsonResult<Purchase>(200,result);

    }
    @RequestMapping(value = "getPurchase",method = RequestMethod.GET)
    public JsonResult<List<Purchase>> getPurchase(HttpSession session){
        List<Purchase> list=purchaseService.getPurchasesByUserId(getUserIdFromSession(session));
        return new JsonResult<>(200,list);
    }
}
