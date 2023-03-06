package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddAddressMapperTest {

    @Test
    @DisplayName("AddAddressMapper -> Address 생성 테스트")
    void addressCreate() {
        AddAddressMapper addAddressMapper = new AddAddressMapper("test", "010111122222");
        Address address = addAddressMapper.addressCreate();
        Assertions.assertThat(address.getCellPhone()).isEqualTo("010111122222");
    }

    @Test
    @DisplayName("AddAddressMapper 생성 테스트")
    void of() {
        AddAddressMapper addAddressMapper = AddAddressMapper.of("test", "010111122222");
        Assertions.assertThat(addAddressMapper.getCellPhone()).isEqualTo("010111122222");
    }

}