package com.example.addressbook.repository.mapper;

import com.example.addressbook.entity.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

class AddressInfoMapperTest {

    @Test
    @DisplayName("AddressInfoMapper 생성 테스트")
    void addressCreate() {
        Address address = BDDMockito.mock(Address.class);
        BDDMockito.when(address.getCellPhone()).thenReturn(010111122222);
        AddressInfoMapper addressInfoMapper = AddressInfoMapper.create(address);
        Assertions.assertThat(addressInfoMapper.getCellPhone()).isEqualTo(010111122222);
    }

}