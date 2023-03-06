package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import java.time.LocalDateTime;
import lombok.Value;

@Value
public class AddressInfoMapper {

    Long idx;

    String name;

    String cellPhone;

    LocalDateTime updateTime;

    LocalDateTime createTime;

    public static AddressInfoMapper create(final Address address) {
        return new AddressInfoMapper(address.getIdx(), address.getName(),
            address.getCellPhone(), address.getUpdateTime(), address.getCreateTime());
    }

}
