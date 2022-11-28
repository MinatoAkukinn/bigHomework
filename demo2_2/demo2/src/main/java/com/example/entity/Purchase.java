package com.example.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "Purchase",description = "商品对象")
public class Purchase {
    private Integer objectId;
    private Integer userId;
    private Integer purchaseId;
    private Date startTime;
    private Date endTime;
    private Integer purchaseStatus;
    private Double totalPrice;

}
