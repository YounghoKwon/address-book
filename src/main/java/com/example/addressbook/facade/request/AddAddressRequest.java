package com.example.addressbook.facade.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class AddAddressRequest {

    @NotNull(message = "성명을 입력해주세요.")
    @Size(min = 1, message = "성명이 빈값입니다.")
    String name;

    @NotNull(message = "핸드폰번호는 필수 값입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9])?([0-9]{3,4})?([0-9]{4})$",
        message = "휴대폰 번호 입력방식이 잘못되었습니다.")
    Integer cellPhone;

}
