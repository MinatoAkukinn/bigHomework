package com.example.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "Purchase",description = "订单对象")
public class Purchase {
    @ApiModelProperty(value = "物品id")
    private Integer objectId;
    @ApiModelProperty(value = "下单人id")
    private Integer userId;
    @ApiModelProperty(value = "订单id")
    private Integer purchaseId;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "订单状态(1~10)")
    private Integer purchaseStatus;
    @ApiModelProperty(value = "总价格")
    private Double totalPrice;

}
