package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AddressInfoMapper {
    Long idx;

    String name;

    Integer cellPhone;

    LocalDateTime updateTime;

    LocalDateTime createTime;

    public static AddressInfoMapper create(final Address address) {
        return new AddressInfoMapper(address.getIdx(), address.getName(),
                address.getCellPhone(), address.getUpdateTime(), address.getCreateTime());
    }

}
