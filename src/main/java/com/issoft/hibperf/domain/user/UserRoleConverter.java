package com.issoft.hibperf.domain.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(UserRole.values())
            .filter(it -> it.name().equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
