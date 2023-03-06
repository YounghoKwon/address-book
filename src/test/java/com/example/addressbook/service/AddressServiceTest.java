package com.example.addressbook.service;

import com.example.addressbook.entity.Address;
import com.example.addressbook.repository.AddressJpaRepository;
import com.example.addressbook.repository.mapper.AddressInfoMapper;
import com.example.addressbook.repository.mapper.ModifyAddressMapper;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    AddressJpaRepository addressJpaRepository;

    @InjectMocks
    AddressService addressService;

    @Test
    @DisplayName("주소록 수정 시 IllegalArgumentException 확인")
    void modify_IllegalArgumentException() {
        ModifyAddressMapper modifyAddressMapper = new ModifyAddressMapper(1L, "홍길동","01065303466");
        Mockito.when(addressJpaRepository.existsById(1L)).thenReturn(false);
        Assertions.assertThatThrownBy(() -> addressService.modify(modifyAddressMapper))
            .hasMessage("존재 하지 않은 주소록 입니다.")
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("주소록 상세 조회시 IllegalArgumentException 확인")
    void getAddressInfo_IllegalArgumentException() {
        Mockito.when(addressJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> addressService.getAddressInfo(Mockito.anyLong()))
            .hasMessage("존재 하지 않은 주소록 입니다.")
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("주소록 삭제 시 IllegalArgumentException 확인")
    void delete_IllegalArgumentException() {

        Mockito.when(addressJpaRepository.existsById(Mockito.anyLong())).thenReturn(false);
        Assertions.assertThatThrownBy(() -> addressService.delete(Mockito.anyLong()))
            .hasMessage("존재 하지 않은 주소록 입니다.")
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("주소록 상세 조회시 성공 확인")
    void getAddressInfo() {

        Address address = Mockito.mock(Address.class);
        Mockito.when(address.getIdx()).thenReturn(1L);

        Mockito.when(addressJpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(address));
        AddressInfoMapper addressInfo = addressService.getAddressInfo(Mockito.anyLong());
        Assertions.assertThat(addressInfo.getIdx()).isEqualTo(1L);

    }
}