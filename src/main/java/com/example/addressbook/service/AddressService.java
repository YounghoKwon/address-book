package com.example.addressbook.service;

import com.example.addressbook.entity.Address;
import com.example.addressbook.exception.NotFoundException;
import com.example.addressbook.repository.AddressJpaRepository;
import com.example.addressbook.repository.AddressMybatisRepository;
import com.example.addressbook.repository.mapper.AddAddressMapper;
import com.example.addressbook.repository.mapper.AddressInfoMapper;
import com.example.addressbook.repository.mapper.AddressListMapper;
import com.example.addressbook.repository.mapper.ModifyAddressMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService {

    private final AddressJpaRepository addressRepository;
    private final AddressMybatisRepository addressMybatisRepository;

    public Page<Map<String, Object>> getList(final String searchText, final Pageable pageable) {
        Map<String, Object> paramMap = new HashMap<>();
        if(Objects.isNull(searchText)){
            paramMap.put("searchText", "");
        }else{
            paramMap.put("searchText", searchText);
        }
        paramMap.put("offset", pageable.getOffset());
        paramMap.put("pageSize", pageable.getPageSize());
        final List<Map<String, Object>> contents = addressMybatisRepository.getList(paramMap);
        final int count = addressMybatisRepository.listCnt(paramMap);
        return new PageImpl<>(contents, pageable, count);
    }

    public void add(final AddAddressMapper addAddressMapper) {
        addressRepository.save(addAddressMapper.addressCreate());
    }

    public void delete(final long idx) {
        if (!existsAddress(idx)) {
            throw new NotFoundException("존재 하지 않은 주소록 입니다.");
        }
        addressRepository.deleteById(idx);
    }

    private boolean existsAddress(final long idx) {
        return addressRepository.existsById(idx);
    }

    public AddressInfoMapper getAddressInfo(final long idx) {
        return addressMybatisRepository.findById(idx)
            .map(AddressInfoMapper::create)
            .orElseThrow(() -> new NotFoundException("존재 하지 않은 주소록 입니다."));
    }

    public void modify(final ModifyAddressMapper modifyAddressMapper) {
        if (!existsAddress(modifyAddressMapper.getIdx())) {
            throw new NotFoundException("존재 하지 않은 주소록 입니다.");
        }
        addressRepository.save(modifyAddressMapper.addressCreate());
    }

}
