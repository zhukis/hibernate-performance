package com.issoft.hibperf.domain.dealbook;

import com.issoft.hibperf.domain.bookauthor.BookAuthor;
import com.issoft.hibperf.domain.deal.Deal;
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

@Data
@NoArgsConstructor
@Entity
@Table(name = "deal_book")
public class DealBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookAuthor bookAuthor;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private BigDecimal price;
}
