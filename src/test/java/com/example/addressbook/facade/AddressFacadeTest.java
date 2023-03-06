package com.example.addressbook.facade;

import static org.junit.jupiter.api.Assertions.*;

import com.example.addressbook.facade.request.AddAddressRequest;
import com.example.addressbook.facade.request.ModifyAddressRequest;
import com.example.addressbook.facade.response.AddressInfoResponse;
import com.example.addressbook.facade.response.AddressListResponse;
import com.example.addressbook.repository.AddressJpaRepository;
import com.example.addressbook.repository.mapper.AddAddressMapper;
import com.example.addressbook.repository.mapper.AddressInfoMapper;
import com.example.addressbook.repository.mapper.AddressListMapper;
import com.example.addressbook.repository.mapper.ModifyAddressMapper;
import com.example.addressbook.service.AddressService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;


@ExtendWith(MockitoExtension.class)
class AddressFacadeTest {

    @Mock
    AddressService addressService;

    @InjectMocks
    AddressFacade addressFacade;


    @Test
    void getList(){
//        addressService.getList(searchText, pageable);
    }
    @Test
    void getInfo(){
//        addressService.getAddressInfo(idx);
    }

}