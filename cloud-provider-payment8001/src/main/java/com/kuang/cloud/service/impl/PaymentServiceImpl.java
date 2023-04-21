package com.kuang.cloud.service.impl;

import com.kuang.cloud.dao.PaymentDAO;
import com.kuang.cloud.entities.Payment;
import com.kuang.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDAO paymentDAO;
    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
