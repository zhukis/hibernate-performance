package com.issoft.hibperf.domain.deal;

import com.issoft.hibperf.domain.shipping.ShippingCompany;
import com.issoft.hibperf.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "shipping_price", nullable = false)
    private BigDecimal shippingPrice;

    @Column(name = "deal_date", nullable = false)
    private LocalDateTime dealDate;

    @Column(name = "delivery_address", nullable = false, length = 2000)
    private String deliveryAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    private ShippingCompany shippingCompany;
}
