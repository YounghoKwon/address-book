package com.example.addressbook.facade.response;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AddressInfoResponse {

    Long idx;

    String name;

    String cellPhone;

    LocalDateTime updateTime;

    LocalDateTime createTime;

}
