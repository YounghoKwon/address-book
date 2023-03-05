package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AddAddressMapper {

    Long idx;

    String name;

    Integer cellPhone;

    public static AddAddressMapper of(final String name, final Integer cellPhone) {
        return new AddAddressMapper(null, name, cellPhone);
    }

    public Address addressCreate(){
        return new Address(null, name, cellPhone);
    }
}
