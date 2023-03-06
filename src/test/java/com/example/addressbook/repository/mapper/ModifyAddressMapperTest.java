package com.example.addressbook.repository.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModifyAddressMapperTest {
    @Test
    @DisplayName("ModifyAddressMapper 생성 테스트")
    void of(){
        ModifyAddressMapper modifyAddressMapper = ModifyAddressMapper.of(1, "홍길동", "01011114444");
        Assertions.assertThat(modifyAddressMapper.getIdx()).isEqualTo(1);
    }
}