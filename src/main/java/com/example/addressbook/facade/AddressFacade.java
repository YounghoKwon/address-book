package com.example.addressbook.facade;

import com.example.addressbook.facade.request.AddAddressRequest;
import com.example.addressbook.facade.response.AddressListResponse;
import com.example.addressbook.repository.mapper.AddAddressMapper;
import com.example.addressbook.repository.mapper.AddressListMapper;
import com.example.addressbook.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressFacade {
    private final AddressService addressService;

    public List<AddressListResponse> getList(final String searchText, final Pageable pageable) {
        final AddressListMapper list = addressService.getList(searchText, pageable);
        return null;
    }

    public void add(final AddAddressRequest addAddressRequest) {
        AddAddressMapper mapper = AddAddressMapper.of(addAddressRequest.getName(), addAddressRequest.getCellPhone());
        addressService.add(mapper);
    }

    public void delete(final long idx) {
        addressService.delete(idx);
    }
}
