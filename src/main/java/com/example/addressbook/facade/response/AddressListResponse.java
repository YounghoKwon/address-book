package com.example.addressbook.facade.response;

import lombok.Value;

@Value
public class AddressListResponse {
    long idx;
    String name;
    Integer cellPhone;
}
