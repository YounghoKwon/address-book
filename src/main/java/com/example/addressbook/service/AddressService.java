package com.example.addressbook.service;

import com.example.addressbook.repository.AddressJpaRepository;
import com.example.addressbook.repository.mapper.AddAddressMapper;
import com.example.addressbook.repository.mapper.AddressListMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressJpaRepository addressAdapter;

    public AddressListMapper getList(final String searchText, final Pageable pageable) {
        return null;
    }

    public void add(final AddAddressMapper addAddressMapper) {
        addressAdapter.save(addAddressMapper.addressCreate());
    }

    public void delete(final long idx) {
        if(!existsAddress(idx)){
            throw new IllegalArgumentException("존재 하지 않은 주소록 입니다.");
        }
        addressAdapter.deleteById(idx);

    }

    private boolean existsAddress(final long idx) {
        return addressAdapter.existsById(idx);
    }
}
