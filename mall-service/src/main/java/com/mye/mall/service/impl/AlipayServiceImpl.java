package com.mye.mall.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mye.mall.service.PayService;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Map;

public class AlipayServiceImpl implements PayService {
    @Value("${alipay.app-id}")
    private String appId;

    @Override
    public PayResponse createPayment(Long orderId, BigDecimal totalAmount, String subject) {
        //使用支付宝sdk构造支付请求;
        AlipayClient alipayClient = new DefaultAlipayClient();
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setBizContent("{" + "\"out_trade_no\":\"" + orderId + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\","
                + "\"total_amount\":\"" + totalAmount + "\"," + "\"subject\":\"" + subject + "\"," + "}");
        return new PayResponse(alipayClient.pageExecute(request).getBody());
    }

    @Override
    public boolean handleCallbake(Map<String, String> params) {
        return false;
    }
}
