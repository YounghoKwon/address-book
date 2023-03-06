package com.example.addressbook.service;

import com.example.addressbook.repository.AddressJpaRepository;
import com.example.addressbook.repository.mapper.AddAddressMapper;
import com.example.addressbook.repository.mapper.AddressInfoMapper;
import com.example.addressbook.repository.mapper.AddressListMapper;
import com.example.addressbook.repository.mapper.ModifyAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressJpaRepository addressRepository;

    public AddressListMapper getList(final String searchText, final Pageable pageable) {
        return null;
    }

    public void add(final AddAddressMapper addAddressMapper) {
        addressRepository.save(addAddressMapper.addressCreate());
    }

    public void delete(final long idx) {
        if (!existsAddress(idx)) {
            throw new IllegalArgumentException("존재 하지 않은 주소록 입니다.");
        }
        addressRepository.deleteById(idx);
    }

    private boolean existsAddress(final long idx) {
        return addressRepository.existsById(idx);
    }

    public AddressInfoMapper getAddressInfo(final long idx) {
        return addressRepository.findById(idx)
            .map(AddressInfoMapper::create)
            .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 주소록 입니다."));
    }

    public void modify(final ModifyAddressMapper modifyAddressMapper) {
        if (!existsAddress(modifyAddressMapper.getIdx())) {
            throw new IllegalArgumentException("존재 하지 않은 주소록 입니다.");
        }
        addressRepository.save(modifyAddressMapper.addressCreate());
    }

}
