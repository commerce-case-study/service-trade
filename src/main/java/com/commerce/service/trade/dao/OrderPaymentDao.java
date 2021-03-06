package com.commerce.service.trade.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.commerce.service.trade.entities.OrderPayment;

public interface OrderPaymentDao extends JpaRepository<OrderPayment, Long>{

    Optional<OrderPayment> findByPaymentCode(String paymentCode);
    
    @Transactional @Modifying
    @Query("update OrderPayment op set op.status = ?2 where op.paymentCode = ?1")
    int updateOrderPaymentStatus(String paymentCode, String status);
    
    List<OrderPayment> findByOrderIdOrderByIdDesc(Long orderId);
}
