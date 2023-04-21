package com.kuang.cloud.dao;

import com.kuang.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDAO {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
