package com.example.addressbook.controller;

import com.example.addressbook.facade.AddressFacade;
import com.example.addressbook.facade.request.AddAddressRequest;
import com.example.addressbook.facade.request.ModifyAddressRequest;
import com.example.addressbook.facade.response.AddressInfoResponse;
import com.example.addressbook.facade.response.AddressListResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address-book")
public class AddressController {

    private final AddressFacade addressFacade;

    @GetMapping
    public ResponseEntity<List<AddressListResponse>> getList(
        @RequestParam(name = "searchText", required = false) final String searchText,
        final Pageable pageable) {
        return ResponseEntity.ok(addressFacade.getList(searchText, pageable));
    }

    @GetMapping("/{idx}")
    public ResponseEntity<AddressInfoResponse> getAddress(@PathVariable("idx") final long idx) {
        return ResponseEntity.ok(addressFacade.getInfo(idx));
    }

    @PostMapping
    public ResponseEntity<Object> insertAddress(
        @Valid @RequestBody final AddAddressRequest addAddressRequest) {
        addressFacade.add(addAddressRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Object> modifyAddress(
        @Valid @RequestBody final ModifyAddressRequest modifyAddressRequest) {
        addressFacade.modify(modifyAddressRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<Object> deleteAddress(@PathVariable("idx") final long idx) {
        addressFacade.delete(idx);
        return ResponseEntity.ok().build();
    }

}
