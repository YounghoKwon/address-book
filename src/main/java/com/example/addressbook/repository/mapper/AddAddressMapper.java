package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AddAddressMapper {

    String name;

    String cellPhone;

    public static AddAddressMapper of(final String name, final String cellPhone) {
        return new AddAddressMapper(name, cellPhone);
    }

    public Address addressCreate() {
        return new Address(null, name, cellPhone);
    }
}
