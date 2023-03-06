package com.example.addressbook.facade;

import com.example.addressbook.facade.request.AddAddressRequest;
import com.example.addressbook.facade.request.ModifyAddressRequest;
import com.example.addressbook.facade.response.AddressInfoResponse;
import com.example.addressbook.facade.response.AddressListResponse;
import com.example.addressbook.repository.mapper.AddAddressMapper;
import com.example.addressbook.repository.mapper.AddressInfoMapper;
import com.example.addressbook.repository.mapper.ModifyAddressMapper;
import com.example.addressbook.service.AddressService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressFacade {

    private final AddressService addressService;

    public Page<AddressListResponse> getList(final String searchText, final Pageable pageable) {
        final Page<Map<String, Object>> list = addressService.getList(searchText, pageable);
        return list.map(x -> new AddressListResponse(Long.parseLong(x.get("IDX").toString()) ,
            x.get("NAME").toString(),
            x.get("CELLPHONE").toString()));
    }

    public void add(final AddAddressRequest addAddressRequest) {
        final AddAddressMapper mapper = AddAddressMapper.of(addAddressRequest.getName(),
            addAddressRequest.getCellPhone());
        addressService.add(mapper);
    }

    public void delete(final long idx) {
        addressService.delete(idx);
    }

    public void modify(final ModifyAddressRequest modifyAddressRequest) {
        final ModifyAddressMapper mapper = ModifyAddressMapper.of(modifyAddressRequest.getIdx(),
            modifyAddressRequest.getName(), modifyAddressRequest.getCellPhone());
        addressService.modify(mapper);
    }

    public AddressInfoResponse getInfo(final long idx) {
        final AddressInfoMapper addressInfo = addressService.getAddressInfo(idx);
        return new AddressInfoResponse(addressInfo.getIdx(), addressInfo.getName(),
            addressInfo.getCellPhone(), addressInfo.getUpdateTime(), addressInfo.getCreateTime());
    }


}
