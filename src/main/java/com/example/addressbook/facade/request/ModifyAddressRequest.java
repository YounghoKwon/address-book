package com.example.addressbook.facade.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class ModifyAddressRequest {

    @NotNull(message = "주소록 idx 값은 필수 값입니다.")
    Long idx;

    @NotNull(message = "성명을 입력해주세요.")
    @Size(min = 1,message = "성명이 빈값입니다.")
    String name;

    @NotNull(message = "핸드폰번호는 필수 값입니다.")
    Integer cellPhone;
}
