package com.mye.mall.service;

import java.math.BigDecimal;
import java.util.Map;

public interface PayService {
    /**
     * 统一下单支付接口
     * @param orderId 订单id
     * @param totalAmount  支付金额
     * @param subject 商品描述
     */
    PayResponse createPayment(Long orderId, BigDecimal totalAmount, String subject);

    /**
     * 处理支付回调
     */
    boolean handleCallbake(Map<String, String> params);
}
