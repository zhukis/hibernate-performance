package com.issoft.hibperf.domain.bookauthor;

import com.issoft.hibperf.domain.author.Author;
import com.issoft.hibperf.domain.book.Book;
import com.issoft.hibperf.domain.dealbook.DealBook;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book_author")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(
        mappedBy = "bookAuthor",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<DealBook> dealBookList;
}
