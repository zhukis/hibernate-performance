package com.issoft.hibperf.domain.book;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BookTypeConverter implements AttributeConverter<BookType, String> {

    @Override
    public String convertToDatabaseColumn(BookType bookType) {
        if (bookType == null) {
            return null;
        }
        return bookType.name();
    }

    @Override
    public BookType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(BookType.values())
            .filter(it -> it.name().equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
