package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import lombok.Value;

@Value
public class ModifyAddressMapper {
    Long idx;

    String name;

    Integer cellPhone;

    public static ModifyAddressMapper of(final long idx, final String name, final int cellPhone) {
        return new ModifyAddressMapper(idx, name, cellPhone);
    }

    public Address addressCreate(){
        return new Address(idx, name, cellPhone);
    }
}
